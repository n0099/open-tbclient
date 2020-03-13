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
    private static final int jbQ = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds60);
    private static final int jbR = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);
    private bj NQ;
    private TextView diq;
    private View.OnClickListener dkf;
    private RelativeLayout eox;
    private TextView fdo;
    private boolean isShowing;
    private TbImageView jbS;
    private boolean jbT;
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
        this.jbT = false;
        this.isShowing = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setTag(PbBusinessPromotionContainer.this.NQ);
                if (PbBusinessPromotionContainer.this.dkf != null) {
                    PbBusinessPromotionContainer.this.dkf.onClick(view);
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
                        PbBusinessPromotionContainer.this.jbT = false;
                        PbBusinessPromotionContainer.this.cuh();
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
                        PbBusinessPromotionContainer.this.jbT = true;
                        PbBusinessPromotionContainer.this.cuh();
                    }
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.layout_pb_business_promotion, this);
        this.eox = (RelativeLayout) findViewById(R.id.id_pb_business_promotion_wrapper);
        this.jbS = (TbImageView) findViewById(R.id.id_pb_business_promotion_avatar);
        this.diq = (TextView) findViewById(R.id.id_pb_business_promotion_forum_name);
        this.fdo = (TextView) findViewById(R.id.id_pb_business_promotion_attention);
        this.jbS.setRadius(l.getDimens(context, R.dimen.tbds24));
        this.jbS.setConrers(5);
        this.jbS.setDefaultResource(17170445);
        this.jbS.setDefaultBgResource(17170445);
        this.eox.setOnClickListener(this.mOnClickListener);
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
        this.jbS.startLoad(bfVar.getAvatar(), 10, false);
        this.diq.setText(bfVar.getForumName());
        if (!this.mHasInit) {
            this.mHasInit = true;
            this.jbT = bfVar.getIsLike();
            cuh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuh() {
        if (this.jbT) {
            this.fdo.setText(getResources().getString(R.string.followed));
            am.setViewTextColor(this.fdo, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.fdo, 17170445);
            this.fdo.setOnClickListener(null);
            return;
        }
        this.fdo.setText(getResources().getString(R.string.attention));
        am.setViewTextColor(this.fdo, (int) R.color.cp_cont_a);
        am.setBackgroundResource(this.fdo, R.drawable.pb_business_promotion_attention_bg);
        this.fdo.setOnClickListener(this.mOnClickListener);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.diq, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.eox, R.drawable.pb_business_promotion_bg);
        if (this.jbT) {
            am.setViewTextColor(this.fdo, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.fdo, 17170445);
            return;
        }
        am.setViewTextColor(this.fdo, (int) R.color.cp_cont_a);
        am.setBackgroundResource(this.fdo, R.drawable.pb_business_promotion_attention_bg);
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        this.dkf = onClickListener;
    }

    private void rc(boolean z) {
        if (z) {
            setPadding(0, 0, 0, 0);
        } else {
            setPadding(0, jbQ, 0, jbR);
        }
    }

    public void destroy() {
        this.mHasInit = false;
        this.jbT = false;
        this.isShowing = false;
        if (this.mLikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mLikeForumListener);
        }
        if (this.mUnlikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mUnlikeForumListener);
        }
    }
}
