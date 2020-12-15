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
    private TextView kfg;
    private AlphaVideo nQw;
    private RoundRelativeLayout nQx;
    private ImageView nQy;
    private final CustomMessageListener nQz;

    public NewUserRewardDialogView(Context context) {
        this(context, null);
    }

    public NewUserRewardDialogView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewUserRewardDialogView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nQz = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.view.NewUserRewardDialogView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue() && NewUserRewardDialogView.this.nQw != null) {
                    NewUserRewardDialogView.this.nQw.requestRender();
                }
            }
        };
        initUI(context);
        onChangeSkinType();
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.new_user_reward_dialog_layout, this);
        this.nQw = (AlphaVideo) findViewById(R.id.new_user_anim);
        this.nQx = (RoundRelativeLayout) findViewById(R.id.new_user_dialog_text_area);
        this.eAz = (TextView) findViewById(R.id.new_user_dialog_title);
        this.kfg = (TextView) findViewById(R.id.new_user_dialog_desc);
        this.nQy = (ImageView) findViewById(R.id.new_user_dialog_close);
        this.nQx.setAllCornerRound(l.getDimens(context, R.dimen.tbds31));
        this.nQw.setKeepLastFrame(true);
        MessageManager.getInstance().registerListener(this.nQz);
    }

    public void setData(IconStampData iconStampData) {
        if (iconStampData != null) {
            this.eAz.setText(iconStampData.stampTitle);
            this.kfg.setText(iconStampData.stampText);
            if (iconStampData.stampType == 1) {
                this.nQw.setSourceAssets("post_1_times.mp4");
            } else if (iconStampData.stampType == 2) {
                this.nQw.setSourceAssets("reply_1_times.mp4");
            } else if (iconStampData.stampType == 3) {
                this.nQw.setSourceAssets("post_7_times.mp4");
            } else {
                this.nQw.setSourceAssets("reply_7_times.mp4");
            }
            this.nQw.play();
        }
    }

    public void setCloseListener(View.OnClickListener onClickListener) {
        this.nQy.setOnClickListener(onClickListener);
    }

    public void onDestroy() {
        this.nQw.destroy();
        MessageManager.getInstance().unRegisterListener(this.nQz);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.nQx, R.color.CAM_X0211);
        ap.setViewTextColor(this.eAz, R.color.CAM_X0105);
        ap.setViewTextColor(this.kfg, R.color.CAM_X0107);
        ap.setImageResource(this.nQy, R.drawable.icon_use_close_n);
    }
}
