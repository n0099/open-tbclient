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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class PbBusinessPromotionContainer extends RelativeLayout {
    private static final int mqi = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds60);
    private static final int mqj = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);
    private cb amn;
    private TextView fmq;
    private View.OnClickListener foU;
    private RelativeLayout gFn;
    private boolean isShowing;
    private TextView jph;
    private boolean mHasInit;
    private CustomMessageListener mLikeForumListener;
    private final View.OnClickListener mOnClickListener;
    private CustomMessageListener mUnlikeForumListener;
    private TbImageView mqk;
    private boolean mql;

    public PbBusinessPromotionContainer(Context context) {
        this(context, null);
    }

    public PbBusinessPromotionContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbBusinessPromotionContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHasInit = false;
        this.mql = false;
        this.isShowing = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setTag(PbBusinessPromotionContainer.this.amn);
                if (PbBusinessPromotionContainer.this.foU != null) {
                    PbBusinessPromotionContainer.this.foU.onClick(view);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (PbBusinessPromotionContainer.this.amn != null && PbBusinessPromotionContainer.this.amn.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.mql = false;
                        PbBusinessPromotionContainer.this.dvL();
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
                    if (PbBusinessPromotionContainer.this.amn != null && PbBusinessPromotionContainer.this.amn.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.mql = true;
                        PbBusinessPromotionContainer.this.dvL();
                    }
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.layout_pb_business_promotion, this);
        this.gFn = (RelativeLayout) findViewById(R.id.id_pb_business_promotion_wrapper);
        this.mqk = (TbImageView) findViewById(R.id.id_pb_business_promotion_avatar);
        this.fmq = (TextView) findViewById(R.id.id_pb_business_promotion_forum_name);
        this.jph = (TextView) findViewById(R.id.id_pb_business_promotion_attention);
        this.mqk.setRadius(l.getDimens(context, R.dimen.tbds24));
        this.mqk.setConrers(5);
        this.mqk.setDefaultResource(17170445);
        this.mqk.setDefaultBgResource(17170445);
        this.gFn.setOnClickListener(this.mOnClickListener);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
    }

    public void a(cb cbVar, bx bxVar, boolean z) {
        if (cbVar == null || bxVar == null || StringUtils.isNull(bxVar.getForumName())) {
            this.isShowing = false;
            setVisibility(8);
            return;
        }
        this.amn = cbVar;
        wz(z);
        this.isShowing = true;
        setVisibility(0);
        this.mqk.startLoad(bxVar.getAvatar(), 10, false);
        this.fmq.setText(bxVar.getForumName());
        if (!this.mHasInit) {
            this.mHasInit = true;
            this.mql = bxVar.getIsLike();
            dvL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvL() {
        if (this.mql) {
            this.jph.setText(getResources().getString(R.string.followed));
            ap.setViewTextColor(this.jph, R.color.CAM_X0109);
            ap.setBackgroundResource(this.jph, 17170445);
            this.jph.setOnClickListener(null);
            return;
        }
        this.jph.setText(getResources().getString(R.string.attention));
        ap.setViewTextColor(this.jph, R.color.CAM_X0101);
        ap.setBackgroundResource(this.jph, R.drawable.pb_business_promotion_attention_bg);
        this.jph.setOnClickListener(this.mOnClickListener);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.fmq, R.color.CAM_X0105);
        ap.setBackgroundResource(this.gFn, R.drawable.pb_business_promotion_bg);
        if (this.mql) {
            ap.setViewTextColor(this.jph, R.color.CAM_X0109);
            ap.setBackgroundResource(this.jph, 17170445);
            return;
        }
        ap.setViewTextColor(this.jph, R.color.CAM_X0101);
        ap.setBackgroundResource(this.jph, R.drawable.pb_business_promotion_attention_bg);
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        this.foU = onClickListener;
    }

    private void wz(boolean z) {
        if (z) {
            setPadding(0, 0, 0, 0);
        } else {
            setPadding(0, mqi, 0, mqj);
        }
    }

    public void destroy() {
        this.mHasInit = false;
        this.mql = false;
        this.isShowing = false;
        if (this.mLikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mLikeForumListener);
        }
        if (this.mUnlikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mUnlikeForumListener);
        }
    }
}
