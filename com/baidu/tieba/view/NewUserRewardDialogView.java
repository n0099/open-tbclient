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
    private TextView epn;
    private TextView jKS;
    private AlphaVideo nvb;
    private RoundRelativeLayout nvc;
    private ImageView nvd;
    private final CustomMessageListener nve;

    public NewUserRewardDialogView(Context context) {
        this(context, null);
    }

    public NewUserRewardDialogView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewUserRewardDialogView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nve = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.view.NewUserRewardDialogView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue() && NewUserRewardDialogView.this.nvb != null) {
                    NewUserRewardDialogView.this.nvb.requestRender();
                }
            }
        };
        initUI(context);
        onChangeSkinType();
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.new_user_reward_dialog_layout, this);
        this.nvb = (AlphaVideo) findViewById(R.id.new_user_anim);
        this.nvc = (RoundRelativeLayout) findViewById(R.id.new_user_dialog_text_area);
        this.epn = (TextView) findViewById(R.id.new_user_dialog_title);
        this.jKS = (TextView) findViewById(R.id.new_user_dialog_desc);
        this.nvd = (ImageView) findViewById(R.id.new_user_dialog_close);
        this.nvc.setAllCornerRound(l.getDimens(context, R.dimen.tbds31));
        this.nvb.setKeepLastFrame(true);
        MessageManager.getInstance().registerListener(this.nve);
    }

    public void setData(IconStampData iconStampData) {
        if (iconStampData != null) {
            this.epn.setText(iconStampData.stampTitle);
            this.jKS.setText(iconStampData.stampText);
            if (iconStampData.stampType == 1) {
                this.nvb.setSourceAssets("post_1_times.mp4");
            } else if (iconStampData.stampType == 2) {
                this.nvb.setSourceAssets("reply_1_times.mp4");
            } else if (iconStampData.stampType == 3) {
                this.nvb.setSourceAssets("post_7_times.mp4");
            } else {
                this.nvb.setSourceAssets("reply_7_times.mp4");
            }
            this.nvb.play();
        }
    }

    public void setCloseListener(View.OnClickListener onClickListener) {
        this.nvd.setOnClickListener(onClickListener);
    }

    public void onDestroy() {
        this.nvb.destroy();
        MessageManager.getInstance().unRegisterListener(this.nve);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.nvc, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.epn, R.color.cp_cont_b);
        ap.setViewTextColor(this.jKS, R.color.cp_cont_j);
        ap.setImageResource(this.nvd, R.drawable.icon_use_close_n);
    }
}
