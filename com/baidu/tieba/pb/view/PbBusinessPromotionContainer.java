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
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class PbBusinessPromotionContainer extends RelativeLayout {
    private bw ajz;
    private TextView euw;
    private View.OnClickListener ewZ;
    private RelativeLayout fHa;
    private TextView gAY;
    private boolean isShowing;
    private TbImageView kZm;
    private boolean kZn;
    private boolean mHasInit;
    private CustomMessageListener mLikeForumListener;
    private final View.OnClickListener mOnClickListener;
    private CustomMessageListener mUnlikeForumListener;
    private static final int kZl = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds60);
    private static final int izX = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);

    public PbBusinessPromotionContainer(Context context) {
        this(context, null);
    }

    public PbBusinessPromotionContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbBusinessPromotionContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHasInit = false;
        this.kZn = false;
        this.isShowing = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setTag(PbBusinessPromotionContainer.this.ajz);
                if (PbBusinessPromotionContainer.this.ewZ != null) {
                    PbBusinessPromotionContainer.this.ewZ.onClick(view);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (PbBusinessPromotionContainer.this.ajz != null && PbBusinessPromotionContainer.this.ajz.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.kZn = false;
                        PbBusinessPromotionContainer.this.dfy();
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
                    if (PbBusinessPromotionContainer.this.ajz != null && PbBusinessPromotionContainer.this.ajz.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.kZn = true;
                        PbBusinessPromotionContainer.this.dfy();
                    }
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.layout_pb_business_promotion, this);
        this.fHa = (RelativeLayout) findViewById(R.id.id_pb_business_promotion_wrapper);
        this.kZm = (TbImageView) findViewById(R.id.id_pb_business_promotion_avatar);
        this.euw = (TextView) findViewById(R.id.id_pb_business_promotion_forum_name);
        this.gAY = (TextView) findViewById(R.id.id_pb_business_promotion_attention);
        this.kZm.setRadius(l.getDimens(context, R.dimen.tbds24));
        this.kZm.setConrers(5);
        this.kZm.setDefaultResource(17170445);
        this.kZm.setDefaultBgResource(17170445);
        this.fHa.setOnClickListener(this.mOnClickListener);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
    }

    public void a(bw bwVar, bs bsVar, boolean z) {
        if (bwVar == null || bsVar == null || StringUtils.isNull(bsVar.getForumName())) {
            this.isShowing = false;
            setVisibility(8);
            return;
        }
        this.ajz = bwVar;
        up(z);
        this.isShowing = true;
        setVisibility(0);
        this.kZm.startLoad(bsVar.getAvatar(), 10, false);
        this.euw.setText(bsVar.getForumName());
        if (!this.mHasInit) {
            this.mHasInit = true;
            this.kZn = bsVar.getIsLike();
            dfy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfy() {
        if (this.kZn) {
            this.gAY.setText(getResources().getString(R.string.followed));
            ap.setViewTextColor(this.gAY, R.color.cp_cont_d);
            ap.setBackgroundResource(this.gAY, 17170445);
            this.gAY.setOnClickListener(null);
            return;
        }
        this.gAY.setText(getResources().getString(R.string.attention));
        ap.setViewTextColor(this.gAY, R.color.cp_cont_a);
        ap.setBackgroundResource(this.gAY, R.drawable.pb_business_promotion_attention_bg);
        this.gAY.setOnClickListener(this.mOnClickListener);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.euw, R.color.cp_cont_b);
        ap.setBackgroundResource(this.fHa, R.drawable.pb_business_promotion_bg);
        if (this.kZn) {
            ap.setViewTextColor(this.gAY, R.color.cp_cont_d);
            ap.setBackgroundResource(this.gAY, 17170445);
            return;
        }
        ap.setViewTextColor(this.gAY, R.color.cp_cont_a);
        ap.setBackgroundResource(this.gAY, R.drawable.pb_business_promotion_attention_bg);
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        this.ewZ = onClickListener;
    }

    private void up(boolean z) {
        if (z) {
            setPadding(0, 0, 0, 0);
        } else {
            setPadding(0, kZl, 0, izX);
        }
    }

    public void destroy() {
        this.mHasInit = false;
        this.kZn = false;
        this.isShowing = false;
        if (this.mLikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mLikeForumListener);
        }
        if (this.mUnlikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mUnlikeForumListener);
        }
    }
}
