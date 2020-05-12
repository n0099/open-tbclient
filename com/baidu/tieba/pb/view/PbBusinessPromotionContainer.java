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
    private static final int jNB = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds60);
    private static final int jNC = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);
    private bj agC;
    private TextView dIC;
    private View.OnClickListener dKq;
    private RelativeLayout eSq;
    private TextView fIb;
    private boolean isShowing;
    private TbImageView jND;
    private boolean jNE;
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
        this.jNE = false;
        this.isShowing = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setTag(PbBusinessPromotionContainer.this.agC);
                if (PbBusinessPromotionContainer.this.dKq != null) {
                    PbBusinessPromotionContainer.this.dKq.onClick(view);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (PbBusinessPromotionContainer.this.agC != null && PbBusinessPromotionContainer.this.agC.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.jNE = false;
                        PbBusinessPromotionContainer.this.cFe();
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
                    if (PbBusinessPromotionContainer.this.agC != null && PbBusinessPromotionContainer.this.agC.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.jNE = true;
                        PbBusinessPromotionContainer.this.cFe();
                    }
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.layout_pb_business_promotion, this);
        this.eSq = (RelativeLayout) findViewById(R.id.id_pb_business_promotion_wrapper);
        this.jND = (TbImageView) findViewById(R.id.id_pb_business_promotion_avatar);
        this.dIC = (TextView) findViewById(R.id.id_pb_business_promotion_forum_name);
        this.fIb = (TextView) findViewById(R.id.id_pb_business_promotion_attention);
        this.jND.setRadius(l.getDimens(context, R.dimen.tbds24));
        this.jND.setConrers(5);
        this.jND.setDefaultResource(17170445);
        this.jND.setDefaultBgResource(17170445);
        this.eSq.setOnClickListener(this.mOnClickListener);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
    }

    public void a(bj bjVar, bf bfVar, boolean z) {
        if (bjVar == null || bfVar == null || StringUtils.isNull(bfVar.getForumName())) {
            this.isShowing = false;
            setVisibility(8);
            return;
        }
        this.agC = bjVar;
        sm(z);
        this.isShowing = true;
        setVisibility(0);
        this.jND.startLoad(bfVar.getAvatar(), 10, false);
        this.dIC.setText(bfVar.getForumName());
        if (!this.mHasInit) {
            this.mHasInit = true;
            this.jNE = bfVar.getIsLike();
            cFe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFe() {
        if (this.jNE) {
            this.fIb.setText(getResources().getString(R.string.followed));
            am.setViewTextColor(this.fIb, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.fIb, 17170445);
            this.fIb.setOnClickListener(null);
            return;
        }
        this.fIb.setText(getResources().getString(R.string.attention));
        am.setViewTextColor(this.fIb, (int) R.color.cp_cont_a);
        am.setBackgroundResource(this.fIb, R.drawable.pb_business_promotion_attention_bg);
        this.fIb.setOnClickListener(this.mOnClickListener);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.dIC, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.eSq, R.drawable.pb_business_promotion_bg);
        if (this.jNE) {
            am.setViewTextColor(this.fIb, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.fIb, 17170445);
            return;
        }
        am.setViewTextColor(this.fIb, (int) R.color.cp_cont_a);
        am.setBackgroundResource(this.fIb, R.drawable.pb_business_promotion_attention_bg);
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        this.dKq = onClickListener;
    }

    private void sm(boolean z) {
        if (z) {
            setPadding(0, 0, 0, 0);
        } else {
            setPadding(0, jNB, 0, jNC);
        }
    }

    public void destroy() {
        this.mHasInit = false;
        this.jNE = false;
        this.isShowing = false;
        if (this.mLikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mLikeForumListener);
        }
        if (this.mUnlikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mUnlikeForumListener);
        }
    }
}
