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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class PbBusinessPromotionContainer extends RelativeLayout {
    private static final int kfs = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds60);
    private static final int kft = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);
    private bk ahg;
    private TextView dWR;
    private View.OnClickListener dYG;
    private TextView fVX;
    private RelativeLayout feY;
    private boolean isShowing;
    private TbImageView kfu;
    private boolean kfv;
    private boolean mHasInit;
    private CustomMessageListener mLikeForumListener;
    private final View.OnClickListener mOnClickListener;
    private CustomMessageListener mUnlikeForumListener;

    public PbBusinessPromotionContainer(Context context) {
        this(context, null);
    }

    public PbBusinessPromotionContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbBusinessPromotionContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHasInit = false;
        this.kfv = false;
        this.isShowing = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setTag(PbBusinessPromotionContainer.this.ahg);
                if (PbBusinessPromotionContainer.this.dYG != null) {
                    PbBusinessPromotionContainer.this.dYG.onClick(view);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (PbBusinessPromotionContainer.this.ahg != null && PbBusinessPromotionContainer.this.ahg.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.kfv = false;
                        PbBusinessPromotionContainer.this.cMc();
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
                    if (PbBusinessPromotionContainer.this.ahg != null && PbBusinessPromotionContainer.this.ahg.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.kfv = true;
                        PbBusinessPromotionContainer.this.cMc();
                    }
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.layout_pb_business_promotion, this);
        this.feY = (RelativeLayout) findViewById(R.id.id_pb_business_promotion_wrapper);
        this.kfu = (TbImageView) findViewById(R.id.id_pb_business_promotion_avatar);
        this.dWR = (TextView) findViewById(R.id.id_pb_business_promotion_forum_name);
        this.fVX = (TextView) findViewById(R.id.id_pb_business_promotion_attention);
        this.kfu.setRadius(l.getDimens(context, R.dimen.tbds24));
        this.kfu.setConrers(5);
        this.kfu.setDefaultResource(17170445);
        this.kfu.setDefaultBgResource(17170445);
        this.feY.setOnClickListener(this.mOnClickListener);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
    }

    public void a(bk bkVar, bg bgVar, boolean z) {
        if (bkVar == null || bgVar == null || StringUtils.isNull(bgVar.getForumName())) {
            this.isShowing = false;
            setVisibility(8);
            return;
        }
        this.ahg = bkVar;
        sK(z);
        this.isShowing = true;
        setVisibility(0);
        this.kfu.startLoad(bgVar.getAvatar(), 10, false);
        this.dWR.setText(bgVar.getForumName());
        if (!this.mHasInit) {
            this.mHasInit = true;
            this.kfv = bgVar.getIsLike();
            cMc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMc() {
        if (this.kfv) {
            this.fVX.setText(getResources().getString(R.string.followed));
            am.setViewTextColor(this.fVX, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.fVX, 17170445);
            this.fVX.setOnClickListener(null);
            return;
        }
        this.fVX.setText(getResources().getString(R.string.attention));
        am.setViewTextColor(this.fVX, (int) R.color.cp_cont_a);
        am.setBackgroundResource(this.fVX, R.drawable.pb_business_promotion_attention_bg);
        this.fVX.setOnClickListener(this.mOnClickListener);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.dWR, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.feY, R.drawable.pb_business_promotion_bg);
        if (this.kfv) {
            am.setViewTextColor(this.fVX, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.fVX, 17170445);
            return;
        }
        am.setViewTextColor(this.fVX, (int) R.color.cp_cont_a);
        am.setBackgroundResource(this.fVX, R.drawable.pb_business_promotion_attention_bg);
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        this.dYG = onClickListener;
    }

    private void sK(boolean z) {
        if (z) {
            setPadding(0, 0, 0, 0);
        } else {
            setPadding(0, kfs, 0, kft);
        }
    }

    public void destroy() {
        this.mHasInit = false;
        this.kfv = false;
        this.isShowing = false;
        if (this.mLikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mLikeForumListener);
        }
        if (this.mUnlikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mUnlikeForumListener);
        }
    }
}
