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
    private static final int jNx = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds60);
    private static final int jNy = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);
    private bj agz;
    private TextView dIy;
    private View.OnClickListener dKm;
    private RelativeLayout eSl;
    private TextView fHW;
    private boolean isShowing;
    private boolean jNA;
    private TbImageView jNz;
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
        this.jNA = false;
        this.isShowing = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setTag(PbBusinessPromotionContainer.this.agz);
                if (PbBusinessPromotionContainer.this.dKm != null) {
                    PbBusinessPromotionContainer.this.dKm.onClick(view);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (PbBusinessPromotionContainer.this.agz != null && PbBusinessPromotionContainer.this.agz.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.jNA = false;
                        PbBusinessPromotionContainer.this.cFg();
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
                    if (PbBusinessPromotionContainer.this.agz != null && PbBusinessPromotionContainer.this.agz.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.jNA = true;
                        PbBusinessPromotionContainer.this.cFg();
                    }
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.layout_pb_business_promotion, this);
        this.eSl = (RelativeLayout) findViewById(R.id.id_pb_business_promotion_wrapper);
        this.jNz = (TbImageView) findViewById(R.id.id_pb_business_promotion_avatar);
        this.dIy = (TextView) findViewById(R.id.id_pb_business_promotion_forum_name);
        this.fHW = (TextView) findViewById(R.id.id_pb_business_promotion_attention);
        this.jNz.setRadius(l.getDimens(context, R.dimen.tbds24));
        this.jNz.setConrers(5);
        this.jNz.setDefaultResource(17170445);
        this.jNz.setDefaultBgResource(17170445);
        this.eSl.setOnClickListener(this.mOnClickListener);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
    }

    public void a(bj bjVar, bf bfVar, boolean z) {
        if (bjVar == null || bfVar == null || StringUtils.isNull(bfVar.getForumName())) {
            this.isShowing = false;
            setVisibility(8);
            return;
        }
        this.agz = bjVar;
        sm(z);
        this.isShowing = true;
        setVisibility(0);
        this.jNz.startLoad(bfVar.getAvatar(), 10, false);
        this.dIy.setText(bfVar.getForumName());
        if (!this.mHasInit) {
            this.mHasInit = true;
            this.jNA = bfVar.getIsLike();
            cFg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFg() {
        if (this.jNA) {
            this.fHW.setText(getResources().getString(R.string.followed));
            am.setViewTextColor(this.fHW, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.fHW, 17170445);
            this.fHW.setOnClickListener(null);
            return;
        }
        this.fHW.setText(getResources().getString(R.string.attention));
        am.setViewTextColor(this.fHW, (int) R.color.cp_cont_a);
        am.setBackgroundResource(this.fHW, R.drawable.pb_business_promotion_attention_bg);
        this.fHW.setOnClickListener(this.mOnClickListener);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.dIy, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.eSl, R.drawable.pb_business_promotion_bg);
        if (this.jNA) {
            am.setViewTextColor(this.fHW, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.fHW, 17170445);
            return;
        }
        am.setViewTextColor(this.fHW, (int) R.color.cp_cont_a);
        am.setBackgroundResource(this.fHW, R.drawable.pb_business_promotion_attention_bg);
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        this.dKm = onClickListener;
    }

    private void sm(boolean z) {
        if (z) {
            setPadding(0, 0, 0, 0);
        } else {
            setPadding(0, jNx, 0, jNy);
        }
    }

    public void destroy() {
        this.mHasInit = false;
        this.jNA = false;
        this.isShowing = false;
        if (this.mLikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mLikeForumListener);
        }
        if (this.mUnlikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mUnlikeForumListener);
        }
    }
}
