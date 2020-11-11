package com.baidu.tieba.video_net_tip;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.j;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.video.g;
/* loaded from: classes.dex */
public class VideoNetworkStateTipView extends RelativeLayout {
    private Runnable mHideRunnable;
    private int mSkinType;
    private TextView nwv;
    private TextView nww;
    private TextView nwx;

    public VideoNetworkStateTipView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.video_net_tip.VideoNetworkStateTipView.1
            @Override // java.lang.Runnable
            public void run() {
                VideoNetworkStateTipView.this.hide();
            }
        };
        init();
    }

    public VideoNetworkStateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.video_net_tip.VideoNetworkStateTipView.1
            @Override // java.lang.Runnable
            public void run() {
                VideoNetworkStateTipView.this.hide();
            }
        };
        init();
    }

    public VideoNetworkStateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.mHideRunnable = new Runnable() { // from class: com.baidu.tieba.video_net_tip.VideoNetworkStateTipView.1
            @Override // java.lang.Runnable
            public void run() {
                VideoNetworkStateTipView.this.hide();
            }
        };
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.video_network_state_tip, this);
        this.nwv = (TextView) findViewById(R.id.play);
        this.nww = (TextView) findViewById(R.id.free_flow);
        this.nww.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video_net_tip.VideoNetworkStateTipView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.startWebActivity(true, VideoNetworkStateTipView.this.getContext(), VideoNetworkStateTipView.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
            }
        });
        this.nwx = (TextView) findViewById(R.id.play_tips);
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    public boolean dsq() {
        return (hasAgreeToPlay() || g.dOu().dOv() || TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2 || !j.isMobileNet()) ? false : true;
    }

    public void dRM() {
        setVisibility(0);
        this.nwv.setVisibility(0);
        this.nww.setVisibility(0);
        this.nwx.setVisibility(8);
    }

    public void dRN() {
        setVisibility(0);
        this.nwv.setVisibility(8);
        this.nww.setVisibility(8);
        this.nwx.setVisibility(0);
        e.mY().removeCallbacks(this.mHideRunnable);
        e.mY().postDelayed(this.mHideRunnable, IMConnection.RETRY_DELAY_TIMES);
    }

    public void hide() {
        setVisibility(8);
    }

    public void setHasAgreeToPlay(boolean z) {
        TbSingleton.getInstance().setHasAgreeToPlay(z);
    }

    public boolean hasAgreeToPlay() {
        return TbSingleton.getInstance().hasAgreeToPlay();
    }

    public void setPlayViewOnClickListener(View.OnClickListener onClickListener) {
        this.nwv.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.nwv, R.color.cp_cont_a);
            ap.setBackgroundResource(this.nwv, R.drawable.rectangle_background_alpha80);
            ap.setViewTextColor(this.nww, R.color.cp_cont_a);
            ap.setBackgroundResource(this.nww, R.drawable.blue_rectangle_background);
            ap.setViewTextColor(this.nwx, R.color.cp_cont_a);
            ap.setBackgroundResource(this.nwx, R.drawable.rectangle_background_alpha80);
        }
    }
}
