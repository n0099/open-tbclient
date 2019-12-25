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
/* loaded from: classes6.dex */
public class PbBusinessPromotionContainer extends RelativeLayout {
    private static final int iWt = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds60);
    private static final int iWu = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);
    private bj Nl;
    private TextView ddN;
    private View.OnClickListener dfz;
    private TextView eXo;
    private RelativeLayout ejk;
    private TbImageView iWv;
    private boolean iWw;
    private boolean isShowing;
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
        this.iWw = false;
        this.isShowing = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setTag(PbBusinessPromotionContainer.this.Nl);
                if (PbBusinessPromotionContainer.this.dfz != null) {
                    PbBusinessPromotionContainer.this.dfz.onClick(view);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (PbBusinessPromotionContainer.this.Nl != null && PbBusinessPromotionContainer.this.Nl.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.iWw = false;
                        PbBusinessPromotionContainer.this.crA();
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
                    if (PbBusinessPromotionContainer.this.Nl != null && PbBusinessPromotionContainer.this.Nl.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.iWw = true;
                        PbBusinessPromotionContainer.this.crA();
                    }
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.layout_pb_business_promotion, this);
        this.ejk = (RelativeLayout) findViewById(R.id.id_pb_business_promotion_wrapper);
        this.iWv = (TbImageView) findViewById(R.id.id_pb_business_promotion_avatar);
        this.ddN = (TextView) findViewById(R.id.id_pb_business_promotion_forum_name);
        this.eXo = (TextView) findViewById(R.id.id_pb_business_promotion_attention);
        this.iWv.setRadius(l.getDimens(context, R.dimen.tbds24));
        this.iWv.setConrers(5);
        this.iWv.setDefaultResource(17170445);
        this.iWv.setDefaultBgResource(17170445);
        this.ejk.setOnClickListener(this.mOnClickListener);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
    }

    public void a(bj bjVar, bf bfVar, boolean z) {
        if (bjVar == null || bfVar == null || StringUtils.isNull(bfVar.getForumName())) {
            this.isShowing = false;
            setVisibility(8);
            return;
        }
        this.Nl = bjVar;
        qK(z);
        this.isShowing = true;
        setVisibility(0);
        this.iWv.startLoad(bfVar.getAvatar(), 10, false);
        this.ddN.setText(bfVar.getForumName());
        if (!this.mHasInit) {
            this.mHasInit = true;
            this.iWw = bfVar.getIsLike();
            crA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crA() {
        if (this.iWw) {
            this.eXo.setText(getResources().getString(R.string.followed));
            am.setViewTextColor(this.eXo, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.eXo, 17170445);
            this.eXo.setOnClickListener(null);
            return;
        }
        this.eXo.setText(getResources().getString(R.string.attention));
        am.setViewTextColor(this.eXo, (int) R.color.cp_cont_a);
        am.setBackgroundResource(this.eXo, R.drawable.pb_business_promotion_attention_bg);
        this.eXo.setOnClickListener(this.mOnClickListener);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.ddN, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.ejk, R.drawable.pb_business_promotion_bg);
        if (this.iWw) {
            am.setViewTextColor(this.eXo, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.eXo, 17170445);
            return;
        }
        am.setViewTextColor(this.eXo, (int) R.color.cp_cont_a);
        am.setBackgroundResource(this.eXo, R.drawable.pb_business_promotion_attention_bg);
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        this.dfz = onClickListener;
    }

    private void qK(boolean z) {
        if (z) {
            setPadding(0, 0, 0, 0);
        } else {
            setPadding(0, iWt, 0, iWu);
        }
    }

    public void destroy() {
        this.mHasInit = false;
        this.iWw = false;
        this.isShowing = false;
        if (this.mLikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mLikeForumListener);
        }
        if (this.mUnlikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mUnlikeForumListener);
        }
    }
}
