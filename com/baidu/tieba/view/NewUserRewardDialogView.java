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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.data.IconStampData;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class NewUserRewardDialogView extends LinearLayout {
    private TextView eHx;
    private TextView kvU;
    private AlphaVideo nZq;
    private RoundRelativeLayout nZr;
    private ImageView nZs;
    private final CustomMessageListener nZt;

    public NewUserRewardDialogView(Context context) {
        this(context, null);
    }

    public NewUserRewardDialogView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewUserRewardDialogView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nZt = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.view.NewUserRewardDialogView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue() && NewUserRewardDialogView.this.nZq != null) {
                    NewUserRewardDialogView.this.nZq.requestRender();
                }
            }
        };
        initUI(context);
        onChangeSkinType();
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.new_user_reward_dialog_layout, this);
        this.nZq = (AlphaVideo) findViewById(R.id.new_user_anim);
        this.nZr = (RoundRelativeLayout) findViewById(R.id.new_user_dialog_text_area);
        this.eHx = (TextView) findViewById(R.id.new_user_dialog_title);
        this.kvU = (TextView) findViewById(R.id.new_user_dialog_desc);
        this.nZs = (ImageView) findViewById(R.id.new_user_dialog_close);
        this.nZr.setAllCornerRound(l.getDimens(context, R.dimen.tbds31));
        this.nZq.setKeepLastFrame(true);
        MessageManager.getInstance().registerListener(this.nZt);
    }

    public void setData(IconStampData iconStampData) {
        if (iconStampData != null) {
            this.eHx.setText(iconStampData.stampTitle);
            this.kvU.setText(iconStampData.stampText);
            if (iconStampData.stampType == 1) {
                this.nZq.setSourceAssets("post_1_times.mp4");
            } else if (iconStampData.stampType == 2) {
                this.nZq.setSourceAssets("reply_1_times.mp4");
            } else if (iconStampData.stampType == 3) {
                this.nZq.setSourceAssets("post_7_times.mp4");
            } else {
                this.nZq.setSourceAssets("reply_7_times.mp4");
            }
            this.nZq.play();
        }
    }

    public void setCloseListener(View.OnClickListener onClickListener) {
        this.nZs.setOnClickListener(onClickListener);
    }

    public void onDestroy() {
        this.nZq.destroy();
        MessageManager.getInstance().unRegisterListener(this.nZt);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.nZr, R.color.CAM_X0211);
        ap.setViewTextColor(this.eHx, R.color.CAM_X0105);
        ap.setViewTextColor(this.kvU, R.color.CAM_X0107);
        ap.setImageResource(this.nZs, R.drawable.icon_use_close_n);
    }
}
