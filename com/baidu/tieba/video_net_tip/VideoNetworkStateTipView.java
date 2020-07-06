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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.video.h;
/* loaded from: classes.dex */
public class VideoNetworkStateTipView extends RelativeLayout {
    private Runnable mHideRunnable;
    private int mSkinType;
    private TextView mfk;
    private TextView mfl;
    private TextView mfm;

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
        this.mfk = (TextView) findViewById(R.id.play);
        this.mfl = (TextView) findViewById(R.id.free_flow);
        this.mfl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video_net_tip.VideoNetworkStateTipView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.startWebActivity(true, VideoNetworkStateTipView.this.getContext(), VideoNetworkStateTipView.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
            }
        });
        this.mfm = (TextView) findViewById(R.id.play_tips);
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    public boolean cQF() {
        return (hasAgreeToPlay() || h.dmo().dmp() || TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2 || !j.isMobileNet()) ? false : true;
    }

    public void dpJ() {
        setVisibility(0);
        this.mfk.setVisibility(0);
        this.mfl.setVisibility(0);
        this.mfm.setVisibility(8);
    }

    public void dpK() {
        setVisibility(0);
        this.mfk.setVisibility(8);
        this.mfl.setVisibility(8);
        this.mfm.setVisibility(0);
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
        this.mfk.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            an.setViewTextColor(this.mfk, (int) R.color.cp_cont_a);
            an.setBackgroundResource(this.mfk, R.drawable.rectangle_background_alpha80);
            an.setViewTextColor(this.mfl, (int) R.color.cp_cont_a);
            an.setBackgroundResource(this.mfl, R.drawable.blue_rectangle_background);
            an.setViewTextColor(this.mfm, (int) R.color.cp_cont_a);
            an.setBackgroundResource(this.mfm, R.drawable.rectangle_background_alpha80);
        }
    }
}
