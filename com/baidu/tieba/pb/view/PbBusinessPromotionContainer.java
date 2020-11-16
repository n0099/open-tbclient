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
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class PbBusinessPromotionContainer extends RelativeLayout {
    private static final int lQd = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds60);
    private static final int lQe = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);
    private bx akt;
    private TextView eWc;
    private View.OnClickListener eYG;
    private RelativeLayout gmc;
    private TextView iPe;
    private boolean isShowing;
    private TbImageView lQf;
    private boolean lQg;
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
        this.lQg = false;
        this.isShowing = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setTag(PbBusinessPromotionContainer.this.akt);
                if (PbBusinessPromotionContainer.this.eYG != null) {
                    PbBusinessPromotionContainer.this.eYG.onClick(view);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (PbBusinessPromotionContainer.this.akt != null && PbBusinessPromotionContainer.this.akt.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.lQg = false;
                        PbBusinessPromotionContainer.this.drV();
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
                    if (PbBusinessPromotionContainer.this.akt != null && PbBusinessPromotionContainer.this.akt.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.lQg = true;
                        PbBusinessPromotionContainer.this.drV();
                    }
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.layout_pb_business_promotion, this);
        this.gmc = (RelativeLayout) findViewById(R.id.id_pb_business_promotion_wrapper);
        this.lQf = (TbImageView) findViewById(R.id.id_pb_business_promotion_avatar);
        this.eWc = (TextView) findViewById(R.id.id_pb_business_promotion_forum_name);
        this.iPe = (TextView) findViewById(R.id.id_pb_business_promotion_attention);
        this.lQf.setRadius(l.getDimens(context, R.dimen.tbds24));
        this.lQf.setConrers(5);
        this.lQf.setDefaultResource(17170445);
        this.lQf.setDefaultBgResource(17170445);
        this.gmc.setOnClickListener(this.mOnClickListener);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
    }

    public void a(bx bxVar, bt btVar, boolean z) {
        if (bxVar == null || btVar == null || StringUtils.isNull(btVar.getForumName())) {
            this.isShowing = false;
            setVisibility(8);
            return;
        }
        this.akt = bxVar;
        vH(z);
        this.isShowing = true;
        setVisibility(0);
        this.lQf.startLoad(btVar.getAvatar(), 10, false);
        this.eWc.setText(btVar.getForumName());
        if (!this.mHasInit) {
            this.mHasInit = true;
            this.lQg = btVar.getIsLike();
            drV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drV() {
        if (this.lQg) {
            this.iPe.setText(getResources().getString(R.string.followed));
            ap.setViewTextColor(this.iPe, R.color.CAM_X0109);
            ap.setBackgroundResource(this.iPe, 17170445);
            this.iPe.setOnClickListener(null);
            return;
        }
        this.iPe.setText(getResources().getString(R.string.attention));
        ap.setViewTextColor(this.iPe, R.color.CAM_X0101);
        ap.setBackgroundResource(this.iPe, R.drawable.pb_business_promotion_attention_bg);
        this.iPe.setOnClickListener(this.mOnClickListener);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.eWc, R.color.CAM_X0105);
        ap.setBackgroundResource(this.gmc, R.drawable.pb_business_promotion_bg);
        if (this.lQg) {
            ap.setViewTextColor(this.iPe, R.color.CAM_X0109);
            ap.setBackgroundResource(this.iPe, 17170445);
            return;
        }
        ap.setViewTextColor(this.iPe, R.color.CAM_X0101);
        ap.setBackgroundResource(this.iPe, R.drawable.pb_business_promotion_attention_bg);
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        this.eYG = onClickListener;
    }

    private void vH(boolean z) {
        if (z) {
            setPadding(0, 0, 0, 0);
        } else {
            setPadding(0, lQd, 0, lQe);
        }
    }

    public void destroy() {
        this.mHasInit = false;
        this.lQg = false;
        this.isShowing = false;
        if (this.mLikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mLikeForumListener);
        }
        if (this.mUnlikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mUnlikeForumListener);
        }
    }
}
