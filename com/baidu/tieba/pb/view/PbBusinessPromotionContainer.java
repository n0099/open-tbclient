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
    private static final int ife = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds60);
    private static final int iff = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);
    private boolean abS;
    private boolean cPV;
    private TextView crl;
    private bh cry;
    private View.OnClickListener csD;
    private RelativeLayout dyZ;
    private TextView ehT;
    private TbImageView ifg;
    private boolean ifh;
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
        this.cPV = false;
        this.ifh = false;
        this.abS = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setTag(PbBusinessPromotionContainer.this.cry);
                if (PbBusinessPromotionContainer.this.csD != null) {
                    PbBusinessPromotionContainer.this.csD.onClick(view);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (PbBusinessPromotionContainer.this.cry != null && PbBusinessPromotionContainer.this.cry.getFid() == longValue && PbBusinessPromotionContainer.this.abS) {
                        PbBusinessPromotionContainer.this.ifh = false;
                        PbBusinessPromotionContainer.this.bYj();
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
                    if (PbBusinessPromotionContainer.this.cry != null && PbBusinessPromotionContainer.this.cry.getFid() == longValue && PbBusinessPromotionContainer.this.abS) {
                        PbBusinessPromotionContainer.this.ifh = true;
                        PbBusinessPromotionContainer.this.bYj();
                    }
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.layout_pb_business_promotion, this);
        this.dyZ = (RelativeLayout) findViewById(R.id.id_pb_business_promotion_wrapper);
        this.ifg = (TbImageView) findViewById(R.id.id_pb_business_promotion_avatar);
        this.crl = (TextView) findViewById(R.id.id_pb_business_promotion_forum_name);
        this.ehT = (TextView) findViewById(R.id.id_pb_business_promotion_attention);
        this.ifg.setRadius(l.getDimens(context, R.dimen.tbds24));
        this.ifg.setConrers(5);
        this.ifg.setDefaultResource(17170445);
        this.ifg.setDefaultBgResource(17170445);
        this.dyZ.setOnClickListener(this.mOnClickListener);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
    }

    public void a(bh bhVar, bd bdVar, boolean z) {
        if (bhVar == null || bdVar == null || StringUtils.isNull(bdVar.getForumName())) {
            this.abS = false;
            setVisibility(8);
            return;
        }
        this.cry = bhVar;
        pi(z);
        this.abS = true;
        setVisibility(0);
        this.ifg.startLoad(bdVar.getAvatar(), 10, false);
        this.crl.setText(bdVar.getForumName());
        if (!this.cPV) {
            this.cPV = true;
            this.ifh = bdVar.getIsLike();
            bYj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYj() {
        if (this.ifh) {
            this.ehT.setText(getResources().getString(R.string.followed));
            am.setViewTextColor(this.ehT, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.ehT, 17170445);
            this.ehT.setOnClickListener(null);
            return;
        }
        this.ehT.setText(getResources().getString(R.string.attention));
        am.setViewTextColor(this.ehT, (int) R.color.cp_cont_a);
        am.setBackgroundResource(this.ehT, R.drawable.pb_business_promotion_attention_bg);
        this.ehT.setOnClickListener(this.mOnClickListener);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.crl, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.dyZ, R.drawable.pb_business_promotion_bg);
        if (this.ifh) {
            am.setViewTextColor(this.ehT, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.ehT, 17170445);
            return;
        }
        am.setViewTextColor(this.ehT, (int) R.color.cp_cont_a);
        am.setBackgroundResource(this.ehT, R.drawable.pb_business_promotion_attention_bg);
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        this.csD = onClickListener;
    }

    private void pi(boolean z) {
        if (z) {
            setPadding(0, 0, 0, 0);
        } else {
            setPadding(0, ife, 0, iff);
        }
    }

    public void destroy() {
        this.cPV = false;
        this.ifh = false;
        this.abS = false;
        if (this.mLikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mLikeForumListener);
        }
        if (this.mUnlikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mUnlikeForumListener);
        }
    }
}
