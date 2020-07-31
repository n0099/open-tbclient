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
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class PbBusinessPromotionContainer extends RelativeLayout {
    private bv aii;
    private TextView ekx;
    private View.OnClickListener emR;
    private RelativeLayout fvE;
    private TextView goe;
    private boolean isShowing;
    private TbImageView kJp;
    private boolean kJq;
    private boolean mHasInit;
    private CustomMessageListener mLikeForumListener;
    private final View.OnClickListener mOnClickListener;
    private CustomMessageListener mUnlikeForumListener;
    private static final int kJo = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds60);
    private static final int ilM = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);

    public PbBusinessPromotionContainer(Context context) {
        this(context, null);
    }

    public PbBusinessPromotionContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbBusinessPromotionContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHasInit = false;
        this.kJq = false;
        this.isShowing = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setTag(PbBusinessPromotionContainer.this.aii);
                if (PbBusinessPromotionContainer.this.emR != null) {
                    PbBusinessPromotionContainer.this.emR.onClick(view);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (PbBusinessPromotionContainer.this.aii != null && PbBusinessPromotionContainer.this.aii.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.kJq = false;
                        PbBusinessPromotionContainer.this.cUA();
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
                    if (PbBusinessPromotionContainer.this.aii != null && PbBusinessPromotionContainer.this.aii.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.kJq = true;
                        PbBusinessPromotionContainer.this.cUA();
                    }
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.layout_pb_business_promotion, this);
        this.fvE = (RelativeLayout) findViewById(R.id.id_pb_business_promotion_wrapper);
        this.kJp = (TbImageView) findViewById(R.id.id_pb_business_promotion_avatar);
        this.ekx = (TextView) findViewById(R.id.id_pb_business_promotion_forum_name);
        this.goe = (TextView) findViewById(R.id.id_pb_business_promotion_attention);
        this.kJp.setRadius(l.getDimens(context, R.dimen.tbds24));
        this.kJp.setConrers(5);
        this.kJp.setDefaultResource(17170445);
        this.kJp.setDefaultBgResource(17170445);
        this.fvE.setOnClickListener(this.mOnClickListener);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
    }

    public void a(bv bvVar, br brVar, boolean z) {
        if (bvVar == null || brVar == null || StringUtils.isNull(brVar.getForumName())) {
            this.isShowing = false;
            setVisibility(8);
            return;
        }
        this.aii = bvVar;
        tE(z);
        this.isShowing = true;
        setVisibility(0);
        this.kJp.startLoad(brVar.getAvatar(), 10, false);
        this.ekx.setText(brVar.getForumName());
        if (!this.mHasInit) {
            this.mHasInit = true;
            this.kJq = brVar.getIsLike();
            cUA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUA() {
        if (this.kJq) {
            this.goe.setText(getResources().getString(R.string.followed));
            ao.setViewTextColor(this.goe, R.color.cp_cont_d);
            ao.setBackgroundResource(this.goe, 17170445);
            this.goe.setOnClickListener(null);
            return;
        }
        this.goe.setText(getResources().getString(R.string.attention));
        ao.setViewTextColor(this.goe, R.color.cp_cont_a);
        ao.setBackgroundResource(this.goe, R.drawable.pb_business_promotion_attention_bg);
        this.goe.setOnClickListener(this.mOnClickListener);
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.ekx, R.color.cp_cont_b);
        ao.setBackgroundResource(this.fvE, R.drawable.pb_business_promotion_bg);
        if (this.kJq) {
            ao.setViewTextColor(this.goe, R.color.cp_cont_d);
            ao.setBackgroundResource(this.goe, 17170445);
            return;
        }
        ao.setViewTextColor(this.goe, R.color.cp_cont_a);
        ao.setBackgroundResource(this.goe, R.drawable.pb_business_promotion_attention_bg);
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        this.emR = onClickListener;
    }

    private void tE(boolean z) {
        if (z) {
            setPadding(0, 0, 0, 0);
        } else {
            setPadding(0, kJo, 0, ilM);
        }
    }

    public void destroy() {
        this.mHasInit = false;
        this.kJq = false;
        this.isShowing = false;
        if (this.mLikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mLikeForumListener);
        }
        if (this.mUnlikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mUnlikeForumListener);
        }
    }
}
