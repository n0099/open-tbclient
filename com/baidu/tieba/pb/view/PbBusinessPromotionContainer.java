package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class PbBusinessPromotionContainer extends RelativeLayout {
    private static final int meO = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds60);
    private static final int meP = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);
    private bz ale;
    private TextView fiz;
    private View.OnClickListener flc;
    private RelativeLayout gAG;
    private boolean isShowing;
    private TextView jhC;
    private boolean mHasInit;
    private CustomMessageListener mLikeForumListener;
    private final View.OnClickListener mOnClickListener;
    private CustomMessageListener mUnlikeForumListener;
    private TbImageView meQ;
    private boolean meR;

    public PbBusinessPromotionContainer(Context context) {
        this(context, null);
    }

    public PbBusinessPromotionContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbBusinessPromotionContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHasInit = false;
        this.meR = false;
        this.isShowing = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setTag(PbBusinessPromotionContainer.this.ale);
                if (PbBusinessPromotionContainer.this.flc != null) {
                    PbBusinessPromotionContainer.this.flc.onClick(view);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (PbBusinessPromotionContainer.this.ale != null && PbBusinessPromotionContainer.this.ale.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.meR = false;
                        PbBusinessPromotionContainer.this.dtm();
                    }
                }
            }
        };
        this.mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (PbBusinessPromotionContainer.this.ale != null && PbBusinessPromotionContainer.this.ale.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.meR = true;
                        PbBusinessPromotionContainer.this.dtm();
                    }
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.layout_pb_business_promotion, this);
        this.gAG = (RelativeLayout) findViewById(R.id.id_pb_business_promotion_wrapper);
        this.meQ = (TbImageView) findViewById(R.id.id_pb_business_promotion_avatar);
        this.fiz = (TextView) findViewById(R.id.id_pb_business_promotion_forum_name);
        this.jhC = (TextView) findViewById(R.id.id_pb_business_promotion_attention);
        this.meQ.setRadius(l.getDimens(context, R.dimen.tbds24));
        this.meQ.setConrers(5);
        this.meQ.setDefaultResource(17170445);
        this.meQ.setDefaultBgResource(17170445);
        this.gAG.setOnClickListener(this.mOnClickListener);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
    }

    public void a(bz bzVar, bv bvVar, boolean z) {
        if (bzVar == null || bvVar == null || StringUtils.isNull(bvVar.getForumName())) {
            this.isShowing = false;
            setVisibility(8);
            return;
        }
        this.ale = bzVar;
        wi(z);
        this.isShowing = true;
        setVisibility(0);
        this.meQ.startLoad(bvVar.getAvatar(), 10, false);
        this.fiz.setText(bvVar.getForumName());
        if (!this.mHasInit) {
            this.mHasInit = true;
            this.meR = bvVar.getIsLike();
            dtm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtm() {
        if (this.meR) {
            this.jhC.setText(getResources().getString(R.string.followed));
            ao.setViewTextColor(this.jhC, R.color.CAM_X0109);
            ao.setBackgroundResource(this.jhC, 17170445);
            this.jhC.setOnClickListener(null);
            return;
        }
        this.jhC.setText(getResources().getString(R.string.attention));
        ao.setViewTextColor(this.jhC, R.color.CAM_X0101);
        ao.setBackgroundResource(this.jhC, R.drawable.pb_business_promotion_attention_bg);
        this.jhC.setOnClickListener(this.mOnClickListener);
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.fiz, R.color.CAM_X0105);
        ao.setBackgroundResource(this.gAG, R.drawable.pb_business_promotion_bg);
        if (this.meR) {
            ao.setViewTextColor(this.jhC, R.color.CAM_X0109);
            ao.setBackgroundResource(this.jhC, 17170445);
            return;
        }
        ao.setViewTextColor(this.jhC, R.color.CAM_X0101);
        ao.setBackgroundResource(this.jhC, R.drawable.pb_business_promotion_attention_bg);
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        this.flc = onClickListener;
    }

    private void wi(boolean z) {
        if (z) {
            setPadding(0, 0, 0, 0);
        } else {
            setPadding(0, meO, 0, meP);
        }
    }

    public void destroy() {
        this.mHasInit = false;
        this.meR = false;
        this.isShowing = false;
        if (this.mLikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mLikeForumListener);
        }
        if (this.mUnlikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mUnlikeForumListener);
        }
    }
}
