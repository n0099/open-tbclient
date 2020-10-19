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
    private TextView egP;
    private TextView jyt;
    private AlphaVideo niA;
    private RoundRelativeLayout niB;
    private ImageView niC;
    private final CustomMessageListener niD;

    public NewUserRewardDialogView(Context context) {
        this(context, null);
    }

    public NewUserRewardDialogView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewUserRewardDialogView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.niD = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.view.NewUserRewardDialogView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue() && NewUserRewardDialogView.this.niA != null) {
                    NewUserRewardDialogView.this.niA.requestRender();
                }
            }
        };
        initUI(context);
        onChangeSkinType();
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.new_user_reward_dialog_layout, this);
        this.niA = (AlphaVideo) findViewById(R.id.new_user_anim);
        this.niB = (RoundRelativeLayout) findViewById(R.id.new_user_dialog_text_area);
        this.egP = (TextView) findViewById(R.id.new_user_dialog_title);
        this.jyt = (TextView) findViewById(R.id.new_user_dialog_desc);
        this.niC = (ImageView) findViewById(R.id.new_user_dialog_close);
        this.niB.setAllCornerRound(l.getDimens(context, R.dimen.tbds31));
        this.niA.setKeepLastFrame(true);
        MessageManager.getInstance().registerListener(this.niD);
    }

    public void setData(IconStampData iconStampData) {
        if (iconStampData != null) {
            this.egP.setText(iconStampData.stampTitle);
            this.jyt.setText(iconStampData.stampText);
            if (iconStampData.stampType == 1) {
                this.niA.setSourceAssets("post_1_times.mp4");
            } else if (iconStampData.stampType == 2) {
                this.niA.setSourceAssets("reply_1_times.mp4");
            } else if (iconStampData.stampType == 3) {
                this.niA.setSourceAssets("post_7_times.mp4");
            } else {
                this.niA.setSourceAssets("reply_7_times.mp4");
            }
            this.niA.play();
        }
    }

    public void setCloseListener(View.OnClickListener onClickListener) {
        this.niC.setOnClickListener(onClickListener);
    }

    public void onDestroy() {
        this.niA.destroy();
        MessageManager.getInstance().unRegisterListener(this.niD);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.niB, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.egP, R.color.cp_cont_b);
        ap.setViewTextColor(this.jyt, R.color.cp_cont_j);
        ap.setImageResource(this.niC, R.drawable.icon_use_close_n);
    }
}
