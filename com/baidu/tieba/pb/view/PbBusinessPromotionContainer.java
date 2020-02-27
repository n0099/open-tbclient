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
    private static final int jbC = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds60);
    private static final int jbD = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);
    private bj NQ;
    private TextView dib;
    private View.OnClickListener djR;
    private RelativeLayout eoj;
    private TextView fda;
    private boolean isShowing;
    private TbImageView jbE;
    private boolean jbF;
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
        this.jbF = false;
        this.isShowing = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setTag(PbBusinessPromotionContainer.this.NQ);
                if (PbBusinessPromotionContainer.this.djR != null) {
                    PbBusinessPromotionContainer.this.djR.onClick(view);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (PbBusinessPromotionContainer.this.NQ != null && PbBusinessPromotionContainer.this.NQ.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.jbF = false;
                        PbBusinessPromotionContainer.this.cue();
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
                    if (PbBusinessPromotionContainer.this.NQ != null && PbBusinessPromotionContainer.this.NQ.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.jbF = true;
                        PbBusinessPromotionContainer.this.cue();
                    }
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.layout_pb_business_promotion, this);
        this.eoj = (RelativeLayout) findViewById(R.id.id_pb_business_promotion_wrapper);
        this.jbE = (TbImageView) findViewById(R.id.id_pb_business_promotion_avatar);
        this.dib = (TextView) findViewById(R.id.id_pb_business_promotion_forum_name);
        this.fda = (TextView) findViewById(R.id.id_pb_business_promotion_attention);
        this.jbE.setRadius(l.getDimens(context, R.dimen.tbds24));
        this.jbE.setConrers(5);
        this.jbE.setDefaultResource(17170445);
        this.jbE.setDefaultBgResource(17170445);
        this.eoj.setOnClickListener(this.mOnClickListener);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
    }

    public void a(bj bjVar, bf bfVar, boolean z) {
        if (bjVar == null || bfVar == null || StringUtils.isNull(bfVar.getForumName())) {
            this.isShowing = false;
            setVisibility(8);
            return;
        }
        this.NQ = bjVar;
        rc(z);
        this.isShowing = true;
        setVisibility(0);
        this.jbE.startLoad(bfVar.getAvatar(), 10, false);
        this.dib.setText(bfVar.getForumName());
        if (!this.mHasInit) {
            this.mHasInit = true;
            this.jbF = bfVar.getIsLike();
            cue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cue() {
        if (this.jbF) {
            this.fda.setText(getResources().getString(R.string.followed));
            am.setViewTextColor(this.fda, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.fda, 17170445);
            this.fda.setOnClickListener(null);
            return;
        }
        this.fda.setText(getResources().getString(R.string.attention));
        am.setViewTextColor(this.fda, (int) R.color.cp_cont_a);
        am.setBackgroundResource(this.fda, R.drawable.pb_business_promotion_attention_bg);
        this.fda.setOnClickListener(this.mOnClickListener);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.dib, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.eoj, R.drawable.pb_business_promotion_bg);
        if (this.jbF) {
            am.setViewTextColor(this.fda, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.fda, 17170445);
            return;
        }
        am.setViewTextColor(this.fda, (int) R.color.cp_cont_a);
        am.setBackgroundResource(this.fda, R.drawable.pb_business_promotion_attention_bg);
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        this.djR = onClickListener;
    }

    private void rc(boolean z) {
        if (z) {
            setPadding(0, 0, 0, 0);
        } else {
            setPadding(0, jbC, 0, jbD);
        }
    }

    public void destroy() {
        this.mHasInit = false;
        this.jbF = false;
        this.isShowing = false;
        if (this.mLikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mLikeForumListener);
        }
        if (this.mUnlikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mUnlikeForumListener);
        }
    }
}
