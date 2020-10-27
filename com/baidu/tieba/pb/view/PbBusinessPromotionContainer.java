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
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class PbBusinessPromotionContainer extends RelativeLayout {
    private bw akq;
    private TextView eRg;
    private View.OnClickListener eTJ;
    private RelativeLayout ggH;
    private TextView iIu;
    private boolean isShowing;
    private TbImageView lJT;
    private boolean lJU;
    private boolean mHasInit;
    private CustomMessageListener mLikeForumListener;
    private final View.OnClickListener mOnClickListener;
    private CustomMessageListener mUnlikeForumListener;
    private static final int lJS = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds60);
    private static final int jiF = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);

    public PbBusinessPromotionContainer(Context context) {
        this(context, null);
    }

    public PbBusinessPromotionContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbBusinessPromotionContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHasInit = false;
        this.lJU = false;
        this.isShowing = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setTag(PbBusinessPromotionContainer.this.akq);
                if (PbBusinessPromotionContainer.this.eTJ != null) {
                    PbBusinessPromotionContainer.this.eTJ.onClick(view);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (PbBusinessPromotionContainer.this.akq != null && PbBusinessPromotionContainer.this.akq.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.lJU = false;
                        PbBusinessPromotionContainer.this.dpT();
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
                    if (PbBusinessPromotionContainer.this.akq != null && PbBusinessPromotionContainer.this.akq.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.lJU = true;
                        PbBusinessPromotionContainer.this.dpT();
                    }
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.layout_pb_business_promotion, this);
        this.ggH = (RelativeLayout) findViewById(R.id.id_pb_business_promotion_wrapper);
        this.lJT = (TbImageView) findViewById(R.id.id_pb_business_promotion_avatar);
        this.eRg = (TextView) findViewById(R.id.id_pb_business_promotion_forum_name);
        this.iIu = (TextView) findViewById(R.id.id_pb_business_promotion_attention);
        this.lJT.setRadius(l.getDimens(context, R.dimen.tbds24));
        this.lJT.setConrers(5);
        this.lJT.setDefaultResource(17170445);
        this.lJT.setDefaultBgResource(17170445);
        this.ggH.setOnClickListener(this.mOnClickListener);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
    }

    public void a(bw bwVar, bs bsVar, boolean z) {
        if (bwVar == null || bsVar == null || StringUtils.isNull(bsVar.getForumName())) {
            this.isShowing = false;
            setVisibility(8);
            return;
        }
        this.akq = bwVar;
        vv(z);
        this.isShowing = true;
        setVisibility(0);
        this.lJT.startLoad(bsVar.getAvatar(), 10, false);
        this.eRg.setText(bsVar.getForumName());
        if (!this.mHasInit) {
            this.mHasInit = true;
            this.lJU = bsVar.getIsLike();
            dpT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpT() {
        if (this.lJU) {
            this.iIu.setText(getResources().getString(R.string.followed));
            ap.setViewTextColor(this.iIu, R.color.cp_cont_d);
            ap.setBackgroundResource(this.iIu, 17170445);
            this.iIu.setOnClickListener(null);
            return;
        }
        this.iIu.setText(getResources().getString(R.string.attention));
        ap.setViewTextColor(this.iIu, R.color.cp_cont_a);
        ap.setBackgroundResource(this.iIu, R.drawable.pb_business_promotion_attention_bg);
        this.iIu.setOnClickListener(this.mOnClickListener);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.eRg, R.color.cp_cont_b);
        ap.setBackgroundResource(this.ggH, R.drawable.pb_business_promotion_bg);
        if (this.lJU) {
            ap.setViewTextColor(this.iIu, R.color.cp_cont_d);
            ap.setBackgroundResource(this.iIu, 17170445);
            return;
        }
        ap.setViewTextColor(this.iIu, R.color.cp_cont_a);
        ap.setBackgroundResource(this.iIu, R.drawable.pb_business_promotion_attention_bg);
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        this.eTJ = onClickListener;
    }

    private void vv(boolean z) {
        if (z) {
            setPadding(0, 0, 0, 0);
        } else {
            setPadding(0, lJS, 0, jiF);
        }
    }

    public void destroy() {
        this.mHasInit = false;
        this.lJU = false;
        this.isShowing = false;
        if (this.mLikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mLikeForumListener);
        }
        if (this.mUnlikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mUnlikeForumListener);
        }
    }
}
