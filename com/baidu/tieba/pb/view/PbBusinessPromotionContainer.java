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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class PbBusinessPromotionContainer extends RelativeLayout {
    private static final int mju = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds60);
    private static final int mjv = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);
    private bz alW;
    private TextView fni;
    private View.OnClickListener fpM;
    private RelativeLayout gFm;
    private boolean isShowing;
    private TextView jmj;
    private boolean mHasInit;
    private CustomMessageListener mLikeForumListener;
    private final View.OnClickListener mOnClickListener;
    private CustomMessageListener mUnlikeForumListener;
    private TbImageView mjw;
    private boolean mjx;

    public PbBusinessPromotionContainer(Context context) {
        this(context, null);
    }

    public PbBusinessPromotionContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbBusinessPromotionContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHasInit = false;
        this.mjx = false;
        this.isShowing = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setTag(PbBusinessPromotionContainer.this.alW);
                if (PbBusinessPromotionContainer.this.fpM != null) {
                    PbBusinessPromotionContainer.this.fpM.onClick(view);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (PbBusinessPromotionContainer.this.alW != null && PbBusinessPromotionContainer.this.alW.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.mjx = false;
                        PbBusinessPromotionContainer.this.dxe();
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
                    if (PbBusinessPromotionContainer.this.alW != null && PbBusinessPromotionContainer.this.alW.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.mjx = true;
                        PbBusinessPromotionContainer.this.dxe();
                    }
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.layout_pb_business_promotion, this);
        this.gFm = (RelativeLayout) findViewById(R.id.id_pb_business_promotion_wrapper);
        this.mjw = (TbImageView) findViewById(R.id.id_pb_business_promotion_avatar);
        this.fni = (TextView) findViewById(R.id.id_pb_business_promotion_forum_name);
        this.jmj = (TextView) findViewById(R.id.id_pb_business_promotion_attention);
        this.mjw.setRadius(l.getDimens(context, R.dimen.tbds24));
        this.mjw.setConrers(5);
        this.mjw.setDefaultResource(17170445);
        this.mjw.setDefaultBgResource(17170445);
        this.gFm.setOnClickListener(this.mOnClickListener);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
    }

    public void a(bz bzVar, bv bvVar, boolean z) {
        if (bzVar == null || bvVar == null || StringUtils.isNull(bvVar.getForumName())) {
            this.isShowing = false;
            setVisibility(8);
            return;
        }
        this.alW = bzVar;
        wm(z);
        this.isShowing = true;
        setVisibility(0);
        this.mjw.startLoad(bvVar.getAvatar(), 10, false);
        this.fni.setText(bvVar.getForumName());
        if (!this.mHasInit) {
            this.mHasInit = true;
            this.mjx = bvVar.getIsLike();
            dxe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxe() {
        if (this.mjx) {
            this.jmj.setText(getResources().getString(R.string.followed));
            ao.setViewTextColor(this.jmj, R.color.CAM_X0109);
            ao.setBackgroundResource(this.jmj, 17170445);
            this.jmj.setOnClickListener(null);
            return;
        }
        this.jmj.setText(getResources().getString(R.string.attention));
        ao.setViewTextColor(this.jmj, R.color.CAM_X0101);
        ao.setBackgroundResource(this.jmj, R.drawable.pb_business_promotion_attention_bg);
        this.jmj.setOnClickListener(this.mOnClickListener);
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.fni, R.color.CAM_X0105);
        ao.setBackgroundResource(this.gFm, R.drawable.pb_business_promotion_bg);
        if (this.mjx) {
            ao.setViewTextColor(this.jmj, R.color.CAM_X0109);
            ao.setBackgroundResource(this.jmj, 17170445);
            return;
        }
        ao.setViewTextColor(this.jmj, R.color.CAM_X0101);
        ao.setBackgroundResource(this.jmj, R.drawable.pb_business_promotion_attention_bg);
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        this.fpM = onClickListener;
    }

    private void wm(boolean z) {
        if (z) {
            setPadding(0, 0, 0, 0);
        } else {
            setPadding(0, mju, 0, mjv);
        }
    }

    public void destroy() {
        this.mHasInit = false;
        this.mjx = false;
        this.isShowing = false;
        if (this.mLikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mLikeForumListener);
        }
        if (this.mUnlikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mUnlikeForumListener);
        }
    }
}
