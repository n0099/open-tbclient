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
/* loaded from: classes21.dex */
public class PbBusinessPromotionContainer extends RelativeLayout {
    private bw ajX;
    private TextView ewA;
    private View.OnClickListener ezg;
    private RelativeLayout fKm;
    private TextView ihb;
    private boolean isShowing;
    private TbImageView lie;
    private boolean lif;
    private boolean mHasInit;
    private CustomMessageListener mLikeForumListener;
    private final View.OnClickListener mOnClickListener;
    private CustomMessageListener mUnlikeForumListener;
    private static final int lid = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds60);
    private static final int iHs = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);

    public PbBusinessPromotionContainer(Context context) {
        this(context, null);
    }

    public PbBusinessPromotionContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbBusinessPromotionContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHasInit = false;
        this.lif = false;
        this.isShowing = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setTag(PbBusinessPromotionContainer.this.ajX);
                if (PbBusinessPromotionContainer.this.ezg != null) {
                    PbBusinessPromotionContainer.this.ezg.onClick(view);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (PbBusinessPromotionContainer.this.ajX != null && PbBusinessPromotionContainer.this.ajX.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.lif = false;
                        PbBusinessPromotionContainer.this.djc();
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
                    if (PbBusinessPromotionContainer.this.ajX != null && PbBusinessPromotionContainer.this.ajX.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.lif = true;
                        PbBusinessPromotionContainer.this.djc();
                    }
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.layout_pb_business_promotion, this);
        this.fKm = (RelativeLayout) findViewById(R.id.id_pb_business_promotion_wrapper);
        this.lie = (TbImageView) findViewById(R.id.id_pb_business_promotion_avatar);
        this.ewA = (TextView) findViewById(R.id.id_pb_business_promotion_forum_name);
        this.ihb = (TextView) findViewById(R.id.id_pb_business_promotion_attention);
        this.lie.setRadius(l.getDimens(context, R.dimen.tbds24));
        this.lie.setConrers(5);
        this.lie.setDefaultResource(17170445);
        this.lie.setDefaultBgResource(17170445);
        this.fKm.setOnClickListener(this.mOnClickListener);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
    }

    public void a(bw bwVar, bs bsVar, boolean z) {
        if (bwVar == null || bsVar == null || StringUtils.isNull(bsVar.getForumName())) {
            this.isShowing = false;
            setVisibility(8);
            return;
        }
        this.ajX = bwVar;
        ux(z);
        this.isShowing = true;
        setVisibility(0);
        this.lie.startLoad(bsVar.getAvatar(), 10, false);
        this.ewA.setText(bsVar.getForumName());
        if (!this.mHasInit) {
            this.mHasInit = true;
            this.lif = bsVar.getIsLike();
            djc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void djc() {
        if (this.lif) {
            this.ihb.setText(getResources().getString(R.string.followed));
            ap.setViewTextColor(this.ihb, R.color.cp_cont_d);
            ap.setBackgroundResource(this.ihb, 17170445);
            this.ihb.setOnClickListener(null);
            return;
        }
        this.ihb.setText(getResources().getString(R.string.attention));
        ap.setViewTextColor(this.ihb, R.color.cp_cont_a);
        ap.setBackgroundResource(this.ihb, R.drawable.pb_business_promotion_attention_bg);
        this.ihb.setOnClickListener(this.mOnClickListener);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.ewA, R.color.cp_cont_b);
        ap.setBackgroundResource(this.fKm, R.drawable.pb_business_promotion_bg);
        if (this.lif) {
            ap.setViewTextColor(this.ihb, R.color.cp_cont_d);
            ap.setBackgroundResource(this.ihb, 17170445);
            return;
        }
        ap.setViewTextColor(this.ihb, R.color.cp_cont_a);
        ap.setBackgroundResource(this.ihb, R.drawable.pb_business_promotion_attention_bg);
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        this.ezg = onClickListener;
    }

    private void ux(boolean z) {
        if (z) {
            setPadding(0, 0, 0, 0);
        } else {
            setPadding(0, lid, 0, iHs);
        }
    }

    public void destroy() {
        this.mHasInit = false;
        this.lif = false;
        this.isShowing = false;
        if (this.mLikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mLikeForumListener);
        }
        if (this.mUnlikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mUnlikeForumListener);
        }
    }
}
