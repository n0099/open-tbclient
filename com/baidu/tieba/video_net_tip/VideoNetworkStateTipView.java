package com.baidu.tieba.video_net_tip;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.video.g;
/* loaded from: classes.dex */
public class VideoNetworkStateTipView extends RelativeLayout {
    private Runnable mHideRunnable;
    private int mSkinType;
    private TextView mmA;
    private TextView mmB;
    private TextView mmC;

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
        this.mmA = (TextView) findViewById(R.id.play);
        this.mmB = (TextView) findViewById(R.id.free_flow);
        this.mmB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video_net_tip.VideoNetworkStateTipView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.startWebActivity(true, VideoNetworkStateTipView.this.getContext(), VideoNetworkStateTipView.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
            }
        });
        this.mmC = (TextView) findViewById(R.id.play_tips);
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    public boolean cUv() {
        return (hasAgreeToPlay() || g.dpz().dpA() || TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2 || !j.isMobileNet()) ? false : true;
    }

    public void dsR() {
        setVisibility(0);
        this.mmA.setVisibility(0);
        this.mmB.setVisibility(0);
        this.mmC.setVisibility(8);
    }

    public void dsS() {
        setVisibility(0);
        this.mmA.setVisibility(8);
        this.mmB.setVisibility(8);
        this.mmC.setVisibility(0);
        e.lt().removeCallbacks(this.mHideRunnable);
        e.lt().postDelayed(this.mHideRunnable, 3000L);
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
        this.mmA.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ao.setViewTextColor(this.mmA, R.color.cp_cont_a);
            ao.setBackgroundResource(this.mmA, R.drawable.rectangle_background_alpha80);
            ao.setViewTextColor(this.mmB, R.color.cp_cont_a);
            ao.setBackgroundResource(this.mmB, R.drawable.blue_rectangle_background);
            ao.setViewTextColor(this.mmC, R.color.cp_cont_a);
            ao.setBackgroundResource(this.mmC, R.drawable.rectangle_background_alpha80);
        }
    }
}
