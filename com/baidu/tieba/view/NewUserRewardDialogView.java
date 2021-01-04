package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.searchbox.afx.AlphaVideo;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.data.IconStampData;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class NewUserRewardDialogView extends LinearLayout {
    private TextView eKc;
    private TextView kss;
    private AlphaVideo nTR;
    private RoundRelativeLayout nTS;
    private ImageView nTT;
    private final CustomMessageListener nTU;

    public NewUserRewardDialogView(Context context) {
        this(context, null);
    }

    public NewUserRewardDialogView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewUserRewardDialogView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nTU = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.view.NewUserRewardDialogView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue() && NewUserRewardDialogView.this.nTR != null) {
                    NewUserRewardDialogView.this.nTR.requestRender();
                }
            }
        };
        initUI(context);
        onChangeSkinType();
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.new_user_reward_dialog_layout, this);
        this.nTR = (AlphaVideo) findViewById(R.id.new_user_anim);
        this.nTS = (RoundRelativeLayout) findViewById(R.id.new_user_dialog_text_area);
        this.eKc = (TextView) findViewById(R.id.new_user_dialog_title);
        this.kss = (TextView) findViewById(R.id.new_user_dialog_desc);
        this.nTT = (ImageView) findViewById(R.id.new_user_dialog_close);
        this.nTS.setAllCornerRound(l.getDimens(context, R.dimen.tbds31));
        this.nTR.setKeepLastFrame(true);
        MessageManager.getInstance().registerListener(this.nTU);
    }

    public void setData(IconStampData iconStampData) {
        if (iconStampData != null) {
            this.eKc.setText(iconStampData.stampTitle);
            this.kss.setText(iconStampData.stampText);
            if (iconStampData.stampType == 1) {
                this.nTR.setSourceAssets("post_1_times.mp4");
            } else if (iconStampData.stampType == 2) {
                this.nTR.setSourceAssets("reply_1_times.mp4");
            } else if (iconStampData.stampType == 3) {
                this.nTR.setSourceAssets("post_7_times.mp4");
            } else {
                this.nTR.setSourceAssets("reply_7_times.mp4");
            }
            this.nTR.play();
        }
    }

    public void setCloseListener(View.OnClickListener onClickListener) {
        this.nTT.setOnClickListener(onClickListener);
    }

    public void onDestroy() {
        this.nTR.destroy();
        MessageManager.getInstance().unRegisterListener(this.nTU);
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this.nTS, R.color.CAM_X0211);
        ao.setViewTextColor(this.eKc, R.color.CAM_X0105);
        ao.setViewTextColor(this.kss, R.color.CAM_X0107);
        ao.setImageResource(this.nTT, R.drawable.icon_use_close_n);
    }
}
