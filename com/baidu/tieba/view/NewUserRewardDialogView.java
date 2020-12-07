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
/* loaded from: classes21.dex */
public class NewUserRewardDialogView extends LinearLayout {
    private TextView eAz;
    private TextView kfe;
    private AlphaVideo nQu;
    private RoundRelativeLayout nQv;
    private ImageView nQw;
    private final CustomMessageListener nQx;

    public NewUserRewardDialogView(Context context) {
        this(context, null);
    }

    public NewUserRewardDialogView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewUserRewardDialogView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nQx = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.view.NewUserRewardDialogView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue() && NewUserRewardDialogView.this.nQu != null) {
                    NewUserRewardDialogView.this.nQu.requestRender();
                }
            }
        };
        initUI(context);
        onChangeSkinType();
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.new_user_reward_dialog_layout, this);
        this.nQu = (AlphaVideo) findViewById(R.id.new_user_anim);
        this.nQv = (RoundRelativeLayout) findViewById(R.id.new_user_dialog_text_area);
        this.eAz = (TextView) findViewById(R.id.new_user_dialog_title);
        this.kfe = (TextView) findViewById(R.id.new_user_dialog_desc);
        this.nQw = (ImageView) findViewById(R.id.new_user_dialog_close);
        this.nQv.setAllCornerRound(l.getDimens(context, R.dimen.tbds31));
        this.nQu.setKeepLastFrame(true);
        MessageManager.getInstance().registerListener(this.nQx);
    }

    public void setData(IconStampData iconStampData) {
        if (iconStampData != null) {
            this.eAz.setText(iconStampData.stampTitle);
            this.kfe.setText(iconStampData.stampText);
            if (iconStampData.stampType == 1) {
                this.nQu.setSourceAssets("post_1_times.mp4");
            } else if (iconStampData.stampType == 2) {
                this.nQu.setSourceAssets("reply_1_times.mp4");
            } else if (iconStampData.stampType == 3) {
                this.nQu.setSourceAssets("post_7_times.mp4");
            } else {
                this.nQu.setSourceAssets("reply_7_times.mp4");
            }
            this.nQu.play();
        }
    }

    public void setCloseListener(View.OnClickListener onClickListener) {
        this.nQw.setOnClickListener(onClickListener);
    }

    public void onDestroy() {
        this.nQu.destroy();
        MessageManager.getInstance().unRegisterListener(this.nQx);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.nQv, R.color.CAM_X0211);
        ap.setViewTextColor(this.eAz, R.color.CAM_X0105);
        ap.setViewTextColor(this.kfe, R.color.CAM_X0107);
        ap.setImageResource(this.nQw, R.drawable.icon_use_close_n);
    }
}
