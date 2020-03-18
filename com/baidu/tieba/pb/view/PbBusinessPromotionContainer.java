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
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class PbBusinessPromotionContainer extends RelativeLayout {
    private static final int jdp = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds60);
    private static final int jdq = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);
    private bj NR;
    private TextView diF;
    private View.OnClickListener dks;
    private RelativeLayout eoO;
    private TextView fdM;
    private boolean isShowing;
    private TbImageView jdr;
    private boolean jds;
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
        this.jds = false;
        this.isShowing = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setTag(PbBusinessPromotionContainer.this.NR);
                if (PbBusinessPromotionContainer.this.dks != null) {
                    PbBusinessPromotionContainer.this.dks.onClick(view);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (PbBusinessPromotionContainer.this.NR != null && PbBusinessPromotionContainer.this.NR.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.jds = false;
                        PbBusinessPromotionContainer.this.cuA();
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
                    if (PbBusinessPromotionContainer.this.NR != null && PbBusinessPromotionContainer.this.NR.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.jds = true;
                        PbBusinessPromotionContainer.this.cuA();
                    }
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.layout_pb_business_promotion, this);
        this.eoO = (RelativeLayout) findViewById(R.id.id_pb_business_promotion_wrapper);
        this.jdr = (TbImageView) findViewById(R.id.id_pb_business_promotion_avatar);
        this.diF = (TextView) findViewById(R.id.id_pb_business_promotion_forum_name);
        this.fdM = (TextView) findViewById(R.id.id_pb_business_promotion_attention);
        this.jdr.setRadius(l.getDimens(context, R.dimen.tbds24));
        this.jdr.setConrers(5);
        this.jdr.setDefaultResource(17170445);
        this.jdr.setDefaultBgResource(17170445);
        this.eoO.setOnClickListener(this.mOnClickListener);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
    }

    public void a(bj bjVar, bf bfVar, boolean z) {
        if (bjVar == null || bfVar == null || StringUtils.isNull(bfVar.getForumName())) {
            this.isShowing = false;
            setVisibility(8);
            return;
        }
        this.NR = bjVar;
        ri(z);
        this.isShowing = true;
        setVisibility(0);
        this.jdr.startLoad(bfVar.getAvatar(), 10, false);
        this.diF.setText(bfVar.getForumName());
        if (!this.mHasInit) {
            this.mHasInit = true;
            this.jds = bfVar.getIsLike();
            cuA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuA() {
        if (this.jds) {
            this.fdM.setText(getResources().getString(R.string.followed));
            am.setViewTextColor(this.fdM, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.fdM, 17170445);
            this.fdM.setOnClickListener(null);
            return;
        }
        this.fdM.setText(getResources().getString(R.string.attention));
        am.setViewTextColor(this.fdM, (int) R.color.cp_cont_a);
        am.setBackgroundResource(this.fdM, R.drawable.pb_business_promotion_attention_bg);
        this.fdM.setOnClickListener(this.mOnClickListener);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.diF, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.eoO, R.drawable.pb_business_promotion_bg);
        if (this.jds) {
            am.setViewTextColor(this.fdM, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.fdM, 17170445);
            return;
        }
        am.setViewTextColor(this.fdM, (int) R.color.cp_cont_a);
        am.setBackgroundResource(this.fdM, R.drawable.pb_business_promotion_attention_bg);
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        this.dks = onClickListener;
    }

    private void ri(boolean z) {
        if (z) {
            setPadding(0, 0, 0, 0);
        } else {
            setPadding(0, jdp, 0, jdq);
        }
    }

    public void destroy() {
        this.mHasInit = false;
        this.jds = false;
        this.isShowing = false;
        if (this.mLikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mLikeForumListener);
        }
        if (this.mUnlikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mUnlikeForumListener);
        }
    }
}
