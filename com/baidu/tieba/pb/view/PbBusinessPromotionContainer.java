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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class PbBusinessPromotionContainer extends RelativeLayout {
    private static final int meh = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds60);
    private static final int mei = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);
    private by alu;
    private TextView fdz;
    private View.OnClickListener fgd;
    private RelativeLayout gun;
    private TextView iZX;
    private boolean isShowing;
    private boolean mHasInit;
    private CustomMessageListener mLikeForumListener;
    private final View.OnClickListener mOnClickListener;
    private CustomMessageListener mUnlikeForumListener;
    private TbImageView mej;
    private boolean mek;

    public PbBusinessPromotionContainer(Context context) {
        this(context, null);
    }

    public PbBusinessPromotionContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbBusinessPromotionContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHasInit = false;
        this.mek = false;
        this.isShowing = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.setTag(PbBusinessPromotionContainer.this.alu);
                if (PbBusinessPromotionContainer.this.fgd != null) {
                    PbBusinessPromotionContainer.this.fgd.onClick(view);
                }
            }
        };
        this.mUnlikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.view.PbBusinessPromotionContainer.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    if (PbBusinessPromotionContainer.this.alu != null && PbBusinessPromotionContainer.this.alu.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.mek = false;
                        PbBusinessPromotionContainer.this.dxo();
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
                    if (PbBusinessPromotionContainer.this.alu != null && PbBusinessPromotionContainer.this.alu.getFid() == longValue && PbBusinessPromotionContainer.this.isShowing) {
                        PbBusinessPromotionContainer.this.mek = true;
                        PbBusinessPromotionContainer.this.dxo();
                    }
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.layout_pb_business_promotion, this);
        this.gun = (RelativeLayout) findViewById(R.id.id_pb_business_promotion_wrapper);
        this.mej = (TbImageView) findViewById(R.id.id_pb_business_promotion_avatar);
        this.fdz = (TextView) findViewById(R.id.id_pb_business_promotion_forum_name);
        this.iZX = (TextView) findViewById(R.id.id_pb_business_promotion_attention);
        this.mej.setRadius(l.getDimens(context, R.dimen.tbds24));
        this.mej.setConrers(5);
        this.mej.setDefaultResource(17170445);
        this.mej.setDefaultBgResource(17170445);
        this.gun.setOnClickListener(this.mOnClickListener);
        MessageManager.getInstance().registerListener(this.mLikeForumListener);
        MessageManager.getInstance().registerListener(this.mUnlikeForumListener);
    }

    public void a(by byVar, bu buVar, boolean z) {
        if (byVar == null || buVar == null || StringUtils.isNull(buVar.getForumName())) {
            this.isShowing = false;
            setVisibility(8);
            return;
        }
        this.alu = byVar;
        wl(z);
        this.isShowing = true;
        setVisibility(0);
        this.mej.startLoad(buVar.getAvatar(), 10, false);
        this.fdz.setText(buVar.getForumName());
        if (!this.mHasInit) {
            this.mHasInit = true;
            this.mek = buVar.getIsLike();
            dxo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxo() {
        if (this.mek) {
            this.iZX.setText(getResources().getString(R.string.followed));
            ap.setViewTextColor(this.iZX, R.color.CAM_X0109);
            ap.setBackgroundResource(this.iZX, 17170445);
            this.iZX.setOnClickListener(null);
            return;
        }
        this.iZX.setText(getResources().getString(R.string.attention));
        ap.setViewTextColor(this.iZX, R.color.CAM_X0101);
        ap.setBackgroundResource(this.iZX, R.drawable.pb_business_promotion_attention_bg);
        this.iZX.setOnClickListener(this.mOnClickListener);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.fdz, R.color.CAM_X0105);
        ap.setBackgroundResource(this.gun, R.drawable.pb_business_promotion_bg);
        if (this.mek) {
            ap.setViewTextColor(this.iZX, R.color.CAM_X0109);
            ap.setBackgroundResource(this.iZX, 17170445);
            return;
        }
        ap.setViewTextColor(this.iZX, R.color.CAM_X0101);
        ap.setBackgroundResource(this.iZX, R.drawable.pb_business_promotion_attention_bg);
    }

    public void setAfterItemClickListener(View.OnClickListener onClickListener) {
        this.fgd = onClickListener;
    }

    private void wl(boolean z) {
        if (z) {
            setPadding(0, 0, 0, 0);
        } else {
            setPadding(0, meh, 0, mei);
        }
    }

    public void destroy() {
        this.mHasInit = false;
        this.mek = false;
        this.isShowing = false;
        if (this.mLikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mLikeForumListener);
        }
        if (this.mUnlikeForumListener != null) {
            MessageManager.getInstance().unRegisterListener(this.mUnlikeForumListener);
        }
    }
}
