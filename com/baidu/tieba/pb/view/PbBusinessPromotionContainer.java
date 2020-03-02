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
    private static final int jbE = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds60);
    private static final int jbF = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);
    private bj NQ;
    private TextView dic;
    private View.OnClickListener djS;
    private RelativeLayout eok;
    private TextView fdb;
    private boolean isShowing;
    private TbImageView jbG;
    private boolean jbH;
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
        this.jbH = false;
        this.isShowing = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setTag(PbBusinessPromotionContainer.this.NQ);
                if (PbBusinessPromotionContainer.this.djS != null) {
                    PbBusinessPromotionContainer.this.djS.onClick(view);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (PbBusinessPromotionContainer.this.NQ != null && PbBusinessPromotionContainer.this.NQ.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.jbH = false;
                        PbBusinessPromotionContainer.this.cug();
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
                    if (PbBusinessPromotionContainer.this.NQ != null && PbBusinessPromotionContainer.this.NQ.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.jbH = true;
                        PbBusinessPromotionContainer.this.cug();
                    }
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.layout_pb_business_promotion, this);
        this.eok = (RelativeLayout) findViewById(R.id.id_pb_business_promotion_wrapper);
        this.jbG = (TbImageView) findViewById(R.id.id_pb_business_promotion_avatar);
        this.dic = (TextView) findViewById(R.id.id_pb_business_promotion_forum_name);
        this.fdb = (TextView) findViewById(R.id.id_pb_business_promotion_attention);
        this.jbG.setRadius(l.getDimens(context, R.dimen.tbds24));
        this.jbG.setConrers(5);
        this.jbG.setDefaultResource(17170445);
        this.jbG.setDefaultBgResource(17170445);
        this.eok.setOnClickListener(this.mOnClickListener);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
    }

    public void a(bj bjVar, bf bfVar, boolean z) {
        if (bjVar == null || bfVar == null || StringUtils.isNull(bfVar.getForumName())) {
            this.isShowing = false;
            setVisibility(8);
            return;
        }
        this.NQ = bjVar;
        rc(z);
        this.isShowing = true;
        setVisibility(0);
        this.jbG.startLoad(bfVar.getAvatar(), 10, false);
        this.dic.setText(bfVar.getForumName());
        if (!this.mHasInit) {
            this.mHasInit = true;
            this.jbH = bfVar.getIsLike();
            cug();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cug() {
        if (this.jbH) {
            this.fdb.setText(getResources().getString(R.string.followed));
            am.setViewTextColor(this.fdb, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.fdb, 17170445);
            this.fdb.setOnClickListener(null);
            return;
        }
        this.fdb.setText(getResources().getString(R.string.attention));
        am.setViewTextColor(this.fdb, (int) R.color.cp_cont_a);
        am.setBackgroundResource(this.fdb, R.drawable.pb_business_promotion_attention_bg);
        this.fdb.setOnClickListener(this.mOnClickListener);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.dic, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.eok, R.drawable.pb_business_promotion_bg);
        if (this.jbH) {
            am.setViewTextColor(this.fdb, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.fdb, 17170445);
            return;
        }
        am.setViewTextColor(this.fdb, (int) R.color.cp_cont_a);
        am.setBackgroundResource(this.fdb, R.drawable.pb_business_promotion_attention_bg);
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        this.djS = onClickListener;
    }

    private void rc(boolean z) {
        if (z) {
            setPadding(0, 0, 0, 0);
        } else {
            setPadding(0, jbE, 0, jbF);
        }
    }

    public void destroy() {
        this.mHasInit = false;
        this.jbH = false;
        this.isShowing = false;
        if (this.mLikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mLikeForumListener);
        }
        if (this.mUnlikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mUnlikeForumListener);
        }
    }
}
