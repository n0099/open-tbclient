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
/* loaded from: classes2.dex */
public class VideoNetworkStateTipView extends RelativeLayout {
    private TextView mEp;
    private TextView mEq;
    private TextView mEr;
    private Runnable mHideRunnable;
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
        this.mEp = (TextView) findViewById(R.id.play);
        this.mEq = (TextView) findViewById(R.id.free_flow);
        this.mEq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video_net_tip.VideoNetworkStateTipView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.startWebActivity(true, VideoNetworkStateTipView.this.getContext(), VideoNetworkStateTipView.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
            }
        });
        this.mEr = (TextView) findViewById(R.id.play_tips);
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    public boolean dfs() {
        return (hasAgreeToPlay() || g.dAV().dAW() || TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2 || !j.isMobileNet()) ? false : true;
    }

    public void dEn() {
        setVisibility(0);
        this.mEp.setVisibility(0);
        this.mEq.setVisibility(0);
        this.mEr.setVisibility(8);
    }

    public void dEo() {
        setVisibility(0);
        this.mEp.setVisibility(8);
        this.mEq.setVisibility(8);
        this.mEr.setVisibility(0);
        e.mS().removeCallbacks(this.mHideRunnable);
        e.mS().postDelayed(this.mHideRunnable, IMConnection.RETRY_DELAY_TIMES);
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
        this.mEp.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.mEp, R.color.cp_cont_a);
            ap.setBackgroundResource(this.mEp, R.drawable.rectangle_background_alpha80);
            ap.setViewTextColor(this.mEq, R.color.cp_cont_a);
            ap.setBackgroundResource(this.mEq, R.drawable.blue_rectangle_background);
            ap.setViewTextColor(this.mEr, R.color.cp_cont_a);
            ap.setBackgroundResource(this.mEr, R.drawable.rectangle_background_alpha80);
        }
    }
}
