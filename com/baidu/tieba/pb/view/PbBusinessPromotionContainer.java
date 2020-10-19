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
/* loaded from: classes22.dex */
public class PbBusinessPromotionContainer extends RelativeLayout {
    private bw akp;
    private TextView eIK;
    private View.OnClickListener eLn;
    private RelativeLayout fWD;
    private boolean isShowing;
    private TextView ivY;
    private TbImageView lxv;
    private boolean lxw;
    private boolean mHasInit;
    private CustomMessageListener mLikeForumListener;
    private final View.OnClickListener mOnClickListener;
    private CustomMessageListener mUnlikeForumListener;
    private static final int lxu = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds60);
    private static final int iWi = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);

    public PbBusinessPromotionContainer(Context context) {
        this(context, null);
    }

    public PbBusinessPromotionContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbBusinessPromotionContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHasInit = false;
        this.lxw = false;
        this.isShowing = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setTag(PbBusinessPromotionContainer.this.akp);
                if (PbBusinessPromotionContainer.this.eLn != null) {
                    PbBusinessPromotionContainer.this.eLn.onClick(view);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (PbBusinessPromotionContainer.this.akp != null && PbBusinessPromotionContainer.this.akp.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.lxw = false;
                        PbBusinessPromotionContainer.this.dmL();
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
                    if (PbBusinessPromotionContainer.this.akp != null && PbBusinessPromotionContainer.this.akp.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.lxw = true;
                        PbBusinessPromotionContainer.this.dmL();
                    }
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.layout_pb_business_promotion, this);
        this.fWD = (RelativeLayout) findViewById(R.id.id_pb_business_promotion_wrapper);
        this.lxv = (TbImageView) findViewById(R.id.id_pb_business_promotion_avatar);
        this.eIK = (TextView) findViewById(R.id.id_pb_business_promotion_forum_name);
        this.ivY = (TextView) findViewById(R.id.id_pb_business_promotion_attention);
        this.lxv.setRadius(l.getDimens(context, R.dimen.tbds24));
        this.lxv.setConrers(5);
        this.lxv.setDefaultResource(17170445);
        this.lxv.setDefaultBgResource(17170445);
        this.fWD.setOnClickListener(this.mOnClickListener);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
    }

    public void a(bw bwVar, bs bsVar, boolean z) {
        if (bwVar == null || bsVar == null || StringUtils.isNull(bsVar.getForumName())) {
            this.isShowing = false;
            setVisibility(8);
            return;
        }
        this.akp = bwVar;
        ve(z);
        this.isShowing = true;
        setVisibility(0);
        this.lxv.startLoad(bsVar.getAvatar(), 10, false);
        this.eIK.setText(bsVar.getForumName());
        if (!this.mHasInit) {
            this.mHasInit = true;
            this.lxw = bsVar.getIsLike();
            dmL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmL() {
        if (this.lxw) {
            this.ivY.setText(getResources().getString(R.string.followed));
            ap.setViewTextColor(this.ivY, R.color.cp_cont_d);
            ap.setBackgroundResource(this.ivY, 17170445);
            this.ivY.setOnClickListener(null);
            return;
        }
        this.ivY.setText(getResources().getString(R.string.attention));
        ap.setViewTextColor(this.ivY, R.color.cp_cont_a);
        ap.setBackgroundResource(this.ivY, R.drawable.pb_business_promotion_attention_bg);
        this.ivY.setOnClickListener(this.mOnClickListener);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.eIK, R.color.cp_cont_b);
        ap.setBackgroundResource(this.fWD, R.drawable.pb_business_promotion_bg);
        if (this.lxw) {
            ap.setViewTextColor(this.ivY, R.color.cp_cont_d);
            ap.setBackgroundResource(this.ivY, 17170445);
            return;
        }
        ap.setViewTextColor(this.ivY, R.color.cp_cont_a);
        ap.setBackgroundResource(this.ivY, R.drawable.pb_business_promotion_attention_bg);
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        this.eLn = onClickListener;
    }

    private void ve(boolean z) {
        if (z) {
            setPadding(0, 0, 0, 0);
        } else {
            setPadding(0, lxu, 0, iWi);
        }
    }

    public void destroy() {
        this.mHasInit = false;
        this.lxw = false;
        this.isShowing = false;
        if (this.mLikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mLikeForumListener);
        }
        if (this.mUnlikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mUnlikeForumListener);
        }
    }
}
