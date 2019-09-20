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
    private static final int igu = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds60);
    private static final int igv = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);
    private boolean cFL;
    private TextView ccX;
    private bh cdk;
    private View.OnClickListener cep;
    private RelativeLayout drP;
    private TextView fBJ;
    private TbImageView igw;
    private boolean igx;
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
        this.cFL = false;
        this.igx = false;
        this.isShowing = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setTag(PbBusinessPromotionContainer.this.cdk);
                if (PbBusinessPromotionContainer.this.cep != null) {
                    PbBusinessPromotionContainer.this.cep.onClick(view);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(2001336) { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (PbBusinessPromotionContainer.this.cdk != null && PbBusinessPromotionContainer.this.cdk.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.igx = false;
                        PbBusinessPromotionContainer.this.cbh();
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
                    if (PbBusinessPromotionContainer.this.cdk != null && PbBusinessPromotionContainer.this.cdk.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.igx = true;
                        PbBusinessPromotionContainer.this.cbh();
                    }
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.layout_pb_business_promotion, this);
        this.drP = (RelativeLayout) findViewById(R.id.id_pb_business_promotion_wrapper);
        this.igw = (TbImageView) findViewById(R.id.id_pb_business_promotion_avatar);
        this.ccX = (TextView) findViewById(R.id.id_pb_business_promotion_forum_name);
        this.fBJ = (TextView) findViewById(R.id.id_pb_business_promotion_attention);
        this.igw.setRadius(l.g(context, R.dimen.tbds24));
        this.igw.setConrers(5);
        this.igw.setDefaultResource(17170445);
        this.igw.setDefaultBgResource(17170445);
        this.drP.setOnClickListener(this.mOnClickListener);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
    }

    public void a(bh bhVar, bd bdVar, boolean z) {
        if (bhVar == null || bdVar == null || StringUtils.isNull(bdVar.getForumName())) {
            this.isShowing = false;
            setVisibility(8);
            return;
        }
        this.cdk = bhVar;
        pz(z);
        this.isShowing = true;
        setVisibility(0);
        this.igw.startLoad(bdVar.getAvatar(), 10, false);
        this.ccX.setText(bdVar.getForumName());
        if (!this.cFL) {
            this.cFL = true;
            this.igx = bdVar.getIsLike();
            cbh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbh() {
        if (this.igx) {
            this.fBJ.setText(getResources().getString(R.string.followed));
            am.j(this.fBJ, R.color.cp_cont_d);
            am.k(this.fBJ, 17170445);
            this.fBJ.setOnClickListener(null);
            return;
        }
        this.fBJ.setText(getResources().getString(R.string.attention));
        am.j(this.fBJ, R.color.cp_cont_a);
        am.k(this.fBJ, R.drawable.pb_business_promotion_attention_bg);
        this.fBJ.setOnClickListener(this.mOnClickListener);
    }

    public void onChangeSkinType() {
        am.j(this.ccX, R.color.cp_cont_b);
        am.k(this.drP, R.drawable.pb_business_promotion_bg);
        if (this.igx) {
            am.j(this.fBJ, R.color.cp_cont_d);
            am.k(this.fBJ, 17170445);
            return;
        }
        am.j(this.fBJ, R.color.cp_cont_a);
        am.k(this.fBJ, R.drawable.pb_business_promotion_attention_bg);
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        this.cep = onClickListener;
    }

    private void pz(boolean z) {
        if (z) {
            setPadding(0, 0, 0, 0);
        } else {
            setPadding(0, igu, 0, igv);
        }
    }

    public void destroy() {
        this.cFL = false;
        this.igx = false;
        this.isShowing = false;
        if (this.mLikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mLikeForumListener);
        }
        if (this.mUnlikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mUnlikeForumListener);
        }
    }
}
