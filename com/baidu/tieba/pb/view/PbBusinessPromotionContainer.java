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
/* loaded from: classes7.dex */
public class PbBusinessPromotionContainer extends RelativeLayout {
    private static final int jab = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds60);
    private static final int jac = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);
    private bj Np;
    private TextView ddX;
    private View.OnClickListener dfL;
    private TextView eZN;
    private RelativeLayout ejY;
    private boolean isShowing;
    private TbImageView jad;
    private boolean jae;
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
        this.jae = false;
        this.isShowing = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setTag(PbBusinessPromotionContainer.this.Np);
                if (PbBusinessPromotionContainer.this.dfL != null) {
                    PbBusinessPromotionContainer.this.dfL.onClick(view);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (PbBusinessPromotionContainer.this.Np != null && PbBusinessPromotionContainer.this.Np.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.jae = false;
                        PbBusinessPromotionContainer.this.csJ();
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
                    if (PbBusinessPromotionContainer.this.Np != null && PbBusinessPromotionContainer.this.Np.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.jae = true;
                        PbBusinessPromotionContainer.this.csJ();
                    }
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.layout_pb_business_promotion, this);
        this.ejY = (RelativeLayout) findViewById(R.id.id_pb_business_promotion_wrapper);
        this.jad = (TbImageView) findViewById(R.id.id_pb_business_promotion_avatar);
        this.ddX = (TextView) findViewById(R.id.id_pb_business_promotion_forum_name);
        this.eZN = (TextView) findViewById(R.id.id_pb_business_promotion_attention);
        this.jad.setRadius(l.getDimens(context, R.dimen.tbds24));
        this.jad.setConrers(5);
        this.jad.setDefaultResource(17170445);
        this.jad.setDefaultBgResource(17170445);
        this.ejY.setOnClickListener(this.mOnClickListener);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
    }

    public void a(bj bjVar, bf bfVar, boolean z) {
        if (bjVar == null || bfVar == null || StringUtils.isNull(bfVar.getForumName())) {
            this.isShowing = false;
            setVisibility(8);
            return;
        }
        this.Np = bjVar;
        qX(z);
        this.isShowing = true;
        setVisibility(0);
        this.jad.startLoad(bfVar.getAvatar(), 10, false);
        this.ddX.setText(bfVar.getForumName());
        if (!this.mHasInit) {
            this.mHasInit = true;
            this.jae = bfVar.getIsLike();
            csJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csJ() {
        if (this.jae) {
            this.eZN.setText(getResources().getString(R.string.followed));
            am.setViewTextColor(this.eZN, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.eZN, 17170445);
            this.eZN.setOnClickListener(null);
            return;
        }
        this.eZN.setText(getResources().getString(R.string.attention));
        am.setViewTextColor(this.eZN, (int) R.color.cp_cont_a);
        am.setBackgroundResource(this.eZN, R.drawable.pb_business_promotion_attention_bg);
        this.eZN.setOnClickListener(this.mOnClickListener);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.ddX, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.ejY, R.drawable.pb_business_promotion_bg);
        if (this.jae) {
            am.setViewTextColor(this.eZN, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.eZN, 17170445);
            return;
        }
        am.setViewTextColor(this.eZN, (int) R.color.cp_cont_a);
        am.setBackgroundResource(this.eZN, R.drawable.pb_business_promotion_attention_bg);
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        this.dfL = onClickListener;
    }

    private void qX(boolean z) {
        if (z) {
            setPadding(0, 0, 0, 0);
        } else {
            setPadding(0, jab, 0, jac);
        }
    }

    public void destroy() {
        this.mHasInit = false;
        this.jae = false;
        this.isShowing = false;
        if (this.mLikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mLikeForumListener);
        }
        if (this.mUnlikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mUnlikeForumListener);
        }
    }
}
