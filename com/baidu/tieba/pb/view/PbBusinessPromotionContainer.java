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
    private bw ajx;
    private TextView eus;
    private View.OnClickListener ewV;
    private RelativeLayout fGW;
    private TextView gAU;
    private boolean isShowing;
    private TbImageView kZf;
    private boolean kZg;
    private boolean mHasInit;
    private CustomMessageListener mLikeForumListener;
    private final View.OnClickListener mOnClickListener;
    private CustomMessageListener mUnlikeForumListener;
    private static final int kZe = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds60);
    private static final int izR = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);

    public PbBusinessPromotionContainer(Context context) {
        this(context, null);
    }

    public PbBusinessPromotionContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbBusinessPromotionContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHasInit = false;
        this.kZg = false;
        this.isShowing = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setTag(PbBusinessPromotionContainer.this.ajx);
                if (PbBusinessPromotionContainer.this.ewV != null) {
                    PbBusinessPromotionContainer.this.ewV.onClick(view);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (PbBusinessPromotionContainer.this.ajx != null && PbBusinessPromotionContainer.this.ajx.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.kZg = false;
                        PbBusinessPromotionContainer.this.dfx();
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
                    if (PbBusinessPromotionContainer.this.ajx != null && PbBusinessPromotionContainer.this.ajx.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.kZg = true;
                        PbBusinessPromotionContainer.this.dfx();
                    }
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.layout_pb_business_promotion, this);
        this.fGW = (RelativeLayout) findViewById(R.id.id_pb_business_promotion_wrapper);
        this.kZf = (TbImageView) findViewById(R.id.id_pb_business_promotion_avatar);
        this.eus = (TextView) findViewById(R.id.id_pb_business_promotion_forum_name);
        this.gAU = (TextView) findViewById(R.id.id_pb_business_promotion_attention);
        this.kZf.setRadius(l.getDimens(context, R.dimen.tbds24));
        this.kZf.setConrers(5);
        this.kZf.setDefaultResource(17170445);
        this.kZf.setDefaultBgResource(17170445);
        this.fGW.setOnClickListener(this.mOnClickListener);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
    }

    public void a(bw bwVar, bs bsVar, boolean z) {
        if (bwVar == null || bsVar == null || StringUtils.isNull(bsVar.getForumName())) {
            this.isShowing = false;
            setVisibility(8);
            return;
        }
        this.ajx = bwVar;
        un(z);
        this.isShowing = true;
        setVisibility(0);
        this.kZf.startLoad(bsVar.getAvatar(), 10, false);
        this.eus.setText(bsVar.getForumName());
        if (!this.mHasInit) {
            this.mHasInit = true;
            this.kZg = bsVar.getIsLike();
            dfx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfx() {
        if (this.kZg) {
            this.gAU.setText(getResources().getString(R.string.followed));
            ap.setViewTextColor(this.gAU, R.color.cp_cont_d);
            ap.setBackgroundResource(this.gAU, 17170445);
            this.gAU.setOnClickListener(null);
            return;
        }
        this.gAU.setText(getResources().getString(R.string.attention));
        ap.setViewTextColor(this.gAU, R.color.cp_cont_a);
        ap.setBackgroundResource(this.gAU, R.drawable.pb_business_promotion_attention_bg);
        this.gAU.setOnClickListener(this.mOnClickListener);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.eus, R.color.cp_cont_b);
        ap.setBackgroundResource(this.fGW, R.drawable.pb_business_promotion_bg);
        if (this.kZg) {
            ap.setViewTextColor(this.gAU, R.color.cp_cont_d);
            ap.setBackgroundResource(this.gAU, 17170445);
            return;
        }
        ap.setViewTextColor(this.gAU, R.color.cp_cont_a);
        ap.setBackgroundResource(this.gAU, R.drawable.pb_business_promotion_attention_bg);
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        this.ewV = onClickListener;
    }

    private void un(boolean z) {
        if (z) {
            setPadding(0, 0, 0, 0);
        } else {
            setPadding(0, kZe, 0, izR);
        }
    }

    public void destroy() {
        this.mHasInit = false;
        this.kZg = false;
        this.isShowing = false;
        if (this.mLikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mLikeForumListener);
        }
        if (this.mUnlikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mUnlikeForumListener);
        }
    }
}
