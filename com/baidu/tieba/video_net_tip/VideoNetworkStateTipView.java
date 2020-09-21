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
    private TextView mOs;
    private TextView mOt;
    private TextView mOu;
    private int mSkinType;

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
        this.mOs = (TextView) findViewById(R.id.play);
        this.mOt = (TextView) findViewById(R.id.free_flow);
        this.mOt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video_net_tip.VideoNetworkStateTipView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.startWebActivity(true, VideoNetworkStateTipView.this.getContext(), VideoNetworkStateTipView.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
            }
        });
        this.mOu = (TextView) findViewById(R.id.play_tips);
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    public boolean diX() {
        return (hasAgreeToPlay() || g.dEY().dEZ() || TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2 || !j.isMobileNet()) ? false : true;
    }

    public void dIq() {
        setVisibility(0);
        this.mOs.setVisibility(0);
        this.mOt.setVisibility(0);
        this.mOu.setVisibility(8);
    }

    public void dIr() {
        setVisibility(0);
        this.mOs.setVisibility(8);
        this.mOt.setVisibility(8);
        this.mOu.setVisibility(0);
        e.mX().removeCallbacks(this.mHideRunnable);
        e.mX().postDelayed(this.mHideRunnable, IMConnection.RETRY_DELAY_TIMES);
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
        this.mOs.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.mOs, R.color.cp_cont_a);
            ap.setBackgroundResource(this.mOs, R.drawable.rectangle_background_alpha80);
            ap.setViewTextColor(this.mOt, R.color.cp_cont_a);
            ap.setBackgroundResource(this.mOt, R.drawable.blue_rectangle_background);
            ap.setViewTextColor(this.mOu, R.color.cp_cont_a);
            ap.setBackgroundResource(this.mOu, R.drawable.rectangle_background_alpha80);
        }
    }
}
