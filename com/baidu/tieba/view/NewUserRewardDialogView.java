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
    private TextView evg;
    private TextView jQQ;
    private AlphaVideo nAV;
    private RoundRelativeLayout nAW;
    private ImageView nAX;
    private final CustomMessageListener nAY;

    public NewUserRewardDialogView(Context context) {
        this(context, null);
    }

    public NewUserRewardDialogView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewUserRewardDialogView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nAY = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.view.NewUserRewardDialogView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue() && NewUserRewardDialogView.this.nAV != null) {
                    NewUserRewardDialogView.this.nAV.requestRender();
                }
            }
        };
        initUI(context);
        onChangeSkinType();
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.new_user_reward_dialog_layout, this);
        this.nAV = (AlphaVideo) findViewById(R.id.new_user_anim);
        this.nAW = (RoundRelativeLayout) findViewById(R.id.new_user_dialog_text_area);
        this.evg = (TextView) findViewById(R.id.new_user_dialog_title);
        this.jQQ = (TextView) findViewById(R.id.new_user_dialog_desc);
        this.nAX = (ImageView) findViewById(R.id.new_user_dialog_close);
        this.nAW.setAllCornerRound(l.getDimens(context, R.dimen.tbds31));
        this.nAV.setKeepLastFrame(true);
        MessageManager.getInstance().registerListener(this.nAY);
    }

    public void setData(IconStampData iconStampData) {
        if (iconStampData != null) {
            this.evg.setText(iconStampData.stampTitle);
            this.jQQ.setText(iconStampData.stampText);
            if (iconStampData.stampType == 1) {
                this.nAV.setSourceAssets("post_1_times.mp4");
            } else if (iconStampData.stampType == 2) {
                this.nAV.setSourceAssets("reply_1_times.mp4");
            } else if (iconStampData.stampType == 3) {
                this.nAV.setSourceAssets("post_7_times.mp4");
            } else {
                this.nAV.setSourceAssets("reply_7_times.mp4");
            }
            this.nAV.play();
        }
    }

    public void setCloseListener(View.OnClickListener onClickListener) {
        this.nAX.setOnClickListener(onClickListener);
    }

    public void onDestroy() {
        this.nAV.destroy();
        MessageManager.getInstance().unRegisterListener(this.nAY);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.nAW, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.evg, R.color.cp_cont_b);
        ap.setViewTextColor(this.jQQ, R.color.cp_cont_j);
        ap.setImageResource(this.nAX, R.drawable.icon_use_close_n);
    }
}
