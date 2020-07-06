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
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class PbBusinessPromotionContainer extends RelativeLayout {
    private bu aiq;
    private TextView een;
    private View.OnClickListener egI;
    private RelativeLayout fqu;
    private TextView gjf;
    private boolean isShowing;
    private TbImageView kAn;
    private boolean kAo;
    private boolean mHasInit;
    private CustomMessageListener mLikeForumListener;
    private final View.OnClickListener mOnClickListener;
    private CustomMessageListener mUnlikeForumListener;
    private static final int kAm = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds60);
    private static final int ifL = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);

    public PbBusinessPromotionContainer(Context context) {
        this(context, null);
    }

    public PbBusinessPromotionContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbBusinessPromotionContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHasInit = false;
        this.kAo = false;
        this.isShowing = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setTag(PbBusinessPromotionContainer.this.aiq);
                if (PbBusinessPromotionContainer.this.egI != null) {
                    PbBusinessPromotionContainer.this.egI.onClick(view);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (PbBusinessPromotionContainer.this.aiq != null && PbBusinessPromotionContainer.this.aiq.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.kAo = false;
                        PbBusinessPromotionContainer.this.cQK();
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
                    if (PbBusinessPromotionContainer.this.aiq != null && PbBusinessPromotionContainer.this.aiq.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.kAo = true;
                        PbBusinessPromotionContainer.this.cQK();
                    }
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.layout_pb_business_promotion, this);
        this.fqu = (RelativeLayout) findViewById(R.id.id_pb_business_promotion_wrapper);
        this.kAn = (TbImageView) findViewById(R.id.id_pb_business_promotion_avatar);
        this.een = (TextView) findViewById(R.id.id_pb_business_promotion_forum_name);
        this.gjf = (TextView) findViewById(R.id.id_pb_business_promotion_attention);
        this.kAn.setRadius(l.getDimens(context, R.dimen.tbds24));
        this.kAn.setConrers(5);
        this.kAn.setDefaultResource(17170445);
        this.kAn.setDefaultBgResource(17170445);
        this.fqu.setOnClickListener(this.mOnClickListener);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
    }

    public void a(bu buVar, bq bqVar, boolean z) {
        if (buVar == null || bqVar == null || StringUtils.isNull(bqVar.getForumName())) {
            this.isShowing = false;
            setVisibility(8);
            return;
        }
        this.aiq = buVar;
        sY(z);
        this.isShowing = true;
        setVisibility(0);
        this.kAn.startLoad(bqVar.getAvatar(), 10, false);
        this.een.setText(bqVar.getForumName());
        if (!this.mHasInit) {
            this.mHasInit = true;
            this.kAo = bqVar.getIsLike();
            cQK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQK() {
        if (this.kAo) {
            this.gjf.setText(getResources().getString(R.string.followed));
            an.setViewTextColor(this.gjf, (int) R.color.cp_cont_d);
            an.setBackgroundResource(this.gjf, 17170445);
            this.gjf.setOnClickListener(null);
            return;
        }
        this.gjf.setText(getResources().getString(R.string.attention));
        an.setViewTextColor(this.gjf, (int) R.color.cp_cont_a);
        an.setBackgroundResource(this.gjf, R.drawable.pb_business_promotion_attention_bg);
        this.gjf.setOnClickListener(this.mOnClickListener);
    }

    public void onChangeSkinType() {
        an.setViewTextColor(this.een, (int) R.color.cp_cont_b);
        an.setBackgroundResource(this.fqu, R.drawable.pb_business_promotion_bg);
        if (this.kAo) {
            an.setViewTextColor(this.gjf, (int) R.color.cp_cont_d);
            an.setBackgroundResource(this.gjf, 17170445);
            return;
        }
        an.setViewTextColor(this.gjf, (int) R.color.cp_cont_a);
        an.setBackgroundResource(this.gjf, R.drawable.pb_business_promotion_attention_bg);
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        this.egI = onClickListener;
    }

    private void sY(boolean z) {
        if (z) {
            setPadding(0, 0, 0, 0);
        } else {
            setPadding(0, kAm, 0, ifL);
        }
    }

    public void destroy() {
        this.mHasInit = false;
        this.kAo = false;
        this.isShowing = false;
        if (this.mLikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mLikeForumListener);
        }
        if (this.mUnlikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mUnlikeForumListener);
        }
    }
}
