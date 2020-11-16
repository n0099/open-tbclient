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
    private TextView etx;
    private TextView jRA;
    private AlphaVideo nCs;
    private RoundRelativeLayout nCt;
    private ImageView nCu;
    private final CustomMessageListener nCv;

    public NewUserRewardDialogView(Context context) {
        this(context, null);
    }

    public NewUserRewardDialogView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewUserRewardDialogView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nCv = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.view.NewUserRewardDialogView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue() && NewUserRewardDialogView.this.nCs != null) {
                    NewUserRewardDialogView.this.nCs.requestRender();
                }
            }
        };
        initUI(context);
        onChangeSkinType();
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.new_user_reward_dialog_layout, this);
        this.nCs = (AlphaVideo) findViewById(R.id.new_user_anim);
        this.nCt = (RoundRelativeLayout) findViewById(R.id.new_user_dialog_text_area);
        this.etx = (TextView) findViewById(R.id.new_user_dialog_title);
        this.jRA = (TextView) findViewById(R.id.new_user_dialog_desc);
        this.nCu = (ImageView) findViewById(R.id.new_user_dialog_close);
        this.nCt.setAllCornerRound(l.getDimens(context, R.dimen.tbds31));
        this.nCs.setKeepLastFrame(true);
        MessageManager.getInstance().registerListener(this.nCv);
    }

    public void setData(IconStampData iconStampData) {
        if (iconStampData != null) {
            this.etx.setText(iconStampData.stampTitle);
            this.jRA.setText(iconStampData.stampText);
            if (iconStampData.stampType == 1) {
                this.nCs.setSourceAssets("post_1_times.mp4");
            } else if (iconStampData.stampType == 2) {
                this.nCs.setSourceAssets("reply_1_times.mp4");
            } else if (iconStampData.stampType == 3) {
                this.nCs.setSourceAssets("post_7_times.mp4");
            } else {
                this.nCs.setSourceAssets("reply_7_times.mp4");
            }
            this.nCs.play();
        }
    }

    public void setCloseListener(View.OnClickListener onClickListener) {
        this.nCu.setOnClickListener(onClickListener);
    }

    public void onDestroy() {
        this.nCs.destroy();
        MessageManager.getInstance().unRegisterListener(this.nCv);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.nCt, R.color.CAM_X0211);
        ap.setViewTextColor(this.etx, R.color.CAM_X0105);
        ap.setViewTextColor(this.jRA, R.color.CAM_X0107);
        ap.setImageResource(this.nCu, R.drawable.icon_use_close_n);
    }
}
