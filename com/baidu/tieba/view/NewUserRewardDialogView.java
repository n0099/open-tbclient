package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.searchbox.afx.AlphaVideo;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.data.IconStampData;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class NewUserRewardDialogView extends LinearLayout {
    private TextView dUN;
    private TextView jjv;
    private AlphaVideo mSY;
    private RoundRelativeLayout mSZ;
    private ImageView mTa;
    private final CustomMessageListener mTb;

    public NewUserRewardDialogView(Context context) {
        this(context, null);
    }

    public NewUserRewardDialogView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewUserRewardDialogView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTb = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.view.NewUserRewardDialogView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue() && NewUserRewardDialogView.this.mSY != null) {
                    NewUserRewardDialogView.this.mSY.requestRender();
                }
            }
        };
        initUI(context);
        onChangeSkinType();
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.new_user_reward_dialog_layout, this);
        this.mSY = (AlphaVideo) findViewById(R.id.new_user_anim);
        this.mSZ = (RoundRelativeLayout) findViewById(R.id.new_user_dialog_text_area);
        this.dUN = (TextView) findViewById(R.id.new_user_dialog_title);
        this.jjv = (TextView) findViewById(R.id.new_user_dialog_desc);
        this.mTa = (ImageView) findViewById(R.id.new_user_dialog_close);
        this.mSZ.setAllCornerRound(l.getDimens(context, R.dimen.tbds31));
        this.mSY.setKeepLastFrame(true);
        MessageManager.getInstance().registerListener(this.mTb);
    }

    public void setData(IconStampData iconStampData) {
        if (iconStampData != null) {
            this.dUN.setText(iconStampData.stampTitle);
            this.jjv.setText(iconStampData.stampText);
            if (iconStampData.stampType == 1) {
                this.mSY.setSourceAssets("post_1_times.mp4");
            } else if (iconStampData.stampType == 2) {
                this.mSY.setSourceAssets("reply_1_times.mp4");
            } else if (iconStampData.stampType == 3) {
                this.mSY.setSourceAssets("post_7_times.mp4");
            } else {
                this.mSY.setSourceAssets("reply_7_times.mp4");
            }
            this.mSY.play();
        }
    }

    public void setCloseListener(View.OnClickListener onClickListener) {
        this.mTa.setOnClickListener(onClickListener);
    }

    public void onDestroy() {
        this.mSY.destroy();
        MessageManager.getInstance().unRegisterListener(this.mTb);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.mSZ, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.dUN, R.color.cp_cont_b);
        ap.setViewTextColor(this.jjv, R.color.cp_cont_j);
        ap.setImageResource(this.mTa, R.drawable.icon_use_close_n);
    }
}
