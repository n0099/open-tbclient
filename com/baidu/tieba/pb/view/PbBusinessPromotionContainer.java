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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class PbBusinessPromotionContainer extends RelativeLayout {
    private static final int mnQ = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds60);
    private static final int mnR = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);
    private cb akU;
    private TextView fkQ;
    private View.OnClickListener fnu;
    private RelativeLayout gDq;
    private boolean isShowing;
    private TextView jnk;
    private boolean mHasInit;
    private CustomMessageListener mLikeForumListener;
    private final View.OnClickListener mOnClickListener;
    private CustomMessageListener mUnlikeForumListener;
    private TbImageView mnS;
    private boolean mnT;

    public PbBusinessPromotionContainer(Context context) {
        this(context, null);
    }

    public PbBusinessPromotionContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbBusinessPromotionContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHasInit = false;
        this.mnT = false;
        this.isShowing = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setTag(PbBusinessPromotionContainer.this.akU);
                if (PbBusinessPromotionContainer.this.fnu != null) {
                    PbBusinessPromotionContainer.this.fnu.onClick(view);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (PbBusinessPromotionContainer.this.akU != null && PbBusinessPromotionContainer.this.akU.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.mnT = false;
                        PbBusinessPromotionContainer.this.dvv();
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
                    if (PbBusinessPromotionContainer.this.akU != null && PbBusinessPromotionContainer.this.akU.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.mnT = true;
                        PbBusinessPromotionContainer.this.dvv();
                    }
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.layout_pb_business_promotion, this);
        this.gDq = (RelativeLayout) findViewById(R.id.id_pb_business_promotion_wrapper);
        this.mnS = (TbImageView) findViewById(R.id.id_pb_business_promotion_avatar);
        this.fkQ = (TextView) findViewById(R.id.id_pb_business_promotion_forum_name);
        this.jnk = (TextView) findViewById(R.id.id_pb_business_promotion_attention);
        this.mnS.setRadius(l.getDimens(context, R.dimen.tbds24));
        this.mnS.setConrers(5);
        this.mnS.setDefaultResource(17170445);
        this.mnS.setDefaultBgResource(17170445);
        this.gDq.setOnClickListener(this.mOnClickListener);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
    }

    public void a(cb cbVar, bx bxVar, boolean z) {
        if (cbVar == null || bxVar == null || StringUtils.isNull(bxVar.getForumName())) {
            this.isShowing = false;
            setVisibility(8);
            return;
        }
        this.akU = cbVar;
        wz(z);
        this.isShowing = true;
        setVisibility(0);
        this.mnS.startLoad(bxVar.getAvatar(), 10, false);
        this.fkQ.setText(bxVar.getForumName());
        if (!this.mHasInit) {
            this.mHasInit = true;
            this.mnT = bxVar.getIsLike();
            dvv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvv() {
        if (this.mnT) {
            this.jnk.setText(getResources().getString(R.string.followed));
            ap.setViewTextColor(this.jnk, R.color.CAM_X0109);
            ap.setBackgroundResource(this.jnk, 17170445);
            this.jnk.setOnClickListener(null);
            return;
        }
        this.jnk.setText(getResources().getString(R.string.attention));
        ap.setViewTextColor(this.jnk, R.color.CAM_X0101);
        ap.setBackgroundResource(this.jnk, R.drawable.pb_business_promotion_attention_bg);
        this.jnk.setOnClickListener(this.mOnClickListener);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.fkQ, R.color.CAM_X0105);
        ap.setBackgroundResource(this.gDq, R.drawable.pb_business_promotion_bg);
        if (this.mnT) {
            ap.setViewTextColor(this.jnk, R.color.CAM_X0109);
            ap.setBackgroundResource(this.jnk, 17170445);
            return;
        }
        ap.setViewTextColor(this.jnk, R.color.CAM_X0101);
        ap.setBackgroundResource(this.jnk, R.drawable.pb_business_promotion_attention_bg);
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        this.fnu = onClickListener;
    }

    private void wz(boolean z) {
        if (z) {
            setPadding(0, 0, 0, 0);
        } else {
            setPadding(0, mnQ, 0, mnR);
        }
    }

    public void destroy() {
        this.mHasInit = false;
        this.mnT = false;
        this.isShowing = false;
        if (this.mLikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mLikeForumListener);
        }
        if (this.mUnlikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mUnlikeForumListener);
        }
    }
}
