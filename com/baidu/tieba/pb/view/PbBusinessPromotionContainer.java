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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class PbBusinessPromotionContainer extends RelativeLayout {
    private static final int ien = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds60);
    private static final int ieo = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);
    private boolean abA;
    private boolean cPe;
    private bh cqG;
    private TextView cqt;
    private View.OnClickListener crM;
    private RelativeLayout dyi;
    private TextView ehc;
    private TbImageView iep;
    private boolean ieq;
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
        this.cPe = false;
        this.ieq = false;
        this.abA = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setTag(PbBusinessPromotionContainer.this.cqG);
                if (PbBusinessPromotionContainer.this.crM != null) {
                    PbBusinessPromotionContainer.this.crM.onClick(view);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (PbBusinessPromotionContainer.this.cqG != null && PbBusinessPromotionContainer.this.cqG.getFid() == longValue && PbBusinessPromotionContainer.this.abA) {
                        PbBusinessPromotionContainer.this.ieq = false;
                        PbBusinessPromotionContainer.this.bYh();
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
                    if (PbBusinessPromotionContainer.this.cqG != null && PbBusinessPromotionContainer.this.cqG.getFid() == longValue && PbBusinessPromotionContainer.this.abA) {
                        PbBusinessPromotionContainer.this.ieq = true;
                        PbBusinessPromotionContainer.this.bYh();
                    }
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.layout_pb_business_promotion, this);
        this.dyi = (RelativeLayout) findViewById(R.id.id_pb_business_promotion_wrapper);
        this.iep = (TbImageView) findViewById(R.id.id_pb_business_promotion_avatar);
        this.cqt = (TextView) findViewById(R.id.id_pb_business_promotion_forum_name);
        this.ehc = (TextView) findViewById(R.id.id_pb_business_promotion_attention);
        this.iep.setRadius(l.getDimens(context, R.dimen.tbds24));
        this.iep.setConrers(5);
        this.iep.setDefaultResource(17170445);
        this.iep.setDefaultBgResource(17170445);
        this.dyi.setOnClickListener(this.mOnClickListener);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
    }

    public void a(bh bhVar, bd bdVar, boolean z) {
        if (bhVar == null || bdVar == null || StringUtils.isNull(bdVar.getForumName())) {
            this.abA = false;
            setVisibility(8);
            return;
        }
        this.cqG = bhVar;
        pi(z);
        this.abA = true;
        setVisibility(0);
        this.iep.startLoad(bdVar.getAvatar(), 10, false);
        this.cqt.setText(bdVar.getForumName());
        if (!this.cPe) {
            this.cPe = true;
            this.ieq = bdVar.getIsLike();
            bYh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYh() {
        if (this.ieq) {
            this.ehc.setText(getResources().getString(R.string.followed));
            am.setViewTextColor(this.ehc, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.ehc, 17170445);
            this.ehc.setOnClickListener(null);
            return;
        }
        this.ehc.setText(getResources().getString(R.string.attention));
        am.setViewTextColor(this.ehc, (int) R.color.cp_cont_a);
        am.setBackgroundResource(this.ehc, R.drawable.pb_business_promotion_attention_bg);
        this.ehc.setOnClickListener(this.mOnClickListener);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.cqt, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.dyi, R.drawable.pb_business_promotion_bg);
        if (this.ieq) {
            am.setViewTextColor(this.ehc, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.ehc, 17170445);
            return;
        }
        am.setViewTextColor(this.ehc, (int) R.color.cp_cont_a);
        am.setBackgroundResource(this.ehc, R.drawable.pb_business_promotion_attention_bg);
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        this.crM = onClickListener;
    }

    private void pi(boolean z) {
        if (z) {
            setPadding(0, 0, 0, 0);
        } else {
            setPadding(0, ien, 0, ieo);
        }
    }

    public void destroy() {
        this.cPe = false;
        this.ieq = false;
        this.abA = false;
        if (this.mLikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mLikeForumListener);
        }
        if (this.mUnlikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mUnlikeForumListener);
        }
    }
}
