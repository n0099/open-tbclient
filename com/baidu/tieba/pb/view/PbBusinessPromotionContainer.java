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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class PbBusinessPromotionContainer extends RelativeLayout {
    private static final int iev = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds60);
    private static final int iew = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);
    private boolean cEV;
    private TextView ccd;
    private bh ccq;
    private View.OnClickListener cdw;
    private RelativeLayout dqe;
    private TextView fzW;
    private TbImageView iex;
    private boolean iey;
    private boolean isShowing;
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
        this.cEV = false;
        this.iey = false;
        this.isShowing = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setTag(PbBusinessPromotionContainer.this.ccq);
                if (PbBusinessPromotionContainer.this.cdw != null) {
                    PbBusinessPromotionContainer.this.cdw.onClick(view);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (PbBusinessPromotionContainer.this.ccq != null && PbBusinessPromotionContainer.this.ccq.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.iey = false;
                        PbBusinessPromotionContainer.this.cat();
                    }
                }
            }
        };
        this.mLikeForumListener = new CustomMessageListener(2001335) { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (PbBusinessPromotionContainer.this.ccq != null && PbBusinessPromotionContainer.this.ccq.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.iey = true;
                        PbBusinessPromotionContainer.this.cat();
                    }
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.layout_pb_business_promotion, this);
        this.dqe = (RelativeLayout) findViewById(R.id.id_pb_business_promotion_wrapper);
        this.iex = (TbImageView) findViewById(R.id.id_pb_business_promotion_avatar);
        this.ccd = (TextView) findViewById(R.id.id_pb_business_promotion_forum_name);
        this.fzW = (TextView) findViewById(R.id.id_pb_business_promotion_attention);
        this.iex.setRadius(l.g(context, R.dimen.tbds24));
        this.iex.setConrers(5);
        this.iex.setDefaultResource(17170445);
        this.iex.setDefaultBgResource(17170445);
        this.dqe.setOnClickListener(this.mOnClickListener);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
    }

    public void a(bh bhVar, bd bdVar, boolean z) {
        if (bhVar == null || bdVar == null || StringUtils.isNull(bdVar.getForumName())) {
            this.isShowing = false;
            setVisibility(8);
            return;
        }
        this.ccq = bhVar;
        pv(z);
        this.isShowing = true;
        setVisibility(0);
        this.iex.startLoad(bdVar.getAvatar(), 10, false);
        this.ccd.setText(bdVar.getForumName());
        if (!this.cEV) {
            this.cEV = true;
            this.iey = bdVar.getIsLike();
            cat();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cat() {
        if (this.iey) {
            this.fzW.setText(getResources().getString(R.string.followed));
            am.j(this.fzW, R.color.cp_cont_d);
            am.k(this.fzW, 17170445);
            this.fzW.setOnClickListener(null);
            return;
        }
        this.fzW.setText(getResources().getString(R.string.attention));
        am.j(this.fzW, R.color.cp_btn_a);
        am.k(this.fzW, R.drawable.pb_business_promotion_attention_bg);
        this.fzW.setOnClickListener(this.mOnClickListener);
    }

    public void onChangeSkinType() {
        am.j(this.ccd, R.color.cp_cont_b);
        am.k(this.dqe, R.drawable.pb_business_promotion_bg);
        if (this.iey) {
            am.j(this.fzW, R.color.cp_cont_d);
            am.k(this.fzW, 17170445);
            return;
        }
        am.j(this.fzW, R.color.cp_btn_a);
        am.k(this.fzW, R.drawable.pb_business_promotion_attention_bg);
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        this.cdw = onClickListener;
    }

    private void pv(boolean z) {
        if (z) {
            setPadding(0, 0, 0, 0);
        } else {
            setPadding(0, iev, 0, iew);
        }
    }

    public void destroy() {
        this.cEV = false;
        this.iey = false;
        this.isShowing = false;
        if (this.mLikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mLikeForumListener);
        }
        if (this.mUnlikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mUnlikeForumListener);
        }
    }
}
