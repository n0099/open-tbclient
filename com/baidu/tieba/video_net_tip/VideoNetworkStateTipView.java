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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.video.g;
/* loaded from: classes.dex */
public class VideoNetworkStateTipView extends RelativeLayout {
    private TextView kEb;
    private TextView kEc;
    private TextView kEd;
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
        this.kEb = (TextView) findViewById(R.id.play);
        this.kEc = (TextView) findViewById(R.id.free_flow);
        this.kEc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video_net_tip.VideoNetworkStateTipView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.startWebActivity(true, VideoNetworkStateTipView.this.getContext(), VideoNetworkStateTipView.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
            }
        });
        this.kEd = (TextView) findViewById(R.id.play_tips);
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    public boolean csC() {
        return (hasAgreeToPlay() || g.cNI().cNJ() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !j.isMobileNet()) ? false : true;
    }

    public void cQX() {
        setVisibility(0);
        this.kEb.setVisibility(0);
        this.kEc.setVisibility(0);
        this.kEd.setVisibility(8);
    }

    public void cQY() {
        setVisibility(0);
        this.kEb.setVisibility(8);
        this.kEc.setVisibility(8);
        this.kEd.setVisibility(0);
        e.gx().removeCallbacks(this.mHideRunnable);
        e.gx().postDelayed(this.mHideRunnable, 3000L);
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
        this.kEb.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.kEb, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.kEb, R.drawable.rectangle_background_alpha80);
            am.setViewTextColor(this.kEc, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.kEc, R.drawable.blue_rectangle_background);
            am.setViewTextColor(this.kEd, (int) R.color.cp_cont_a);
            am.setBackgroundResource(this.kEd, R.drawable.rectangle_background_alpha80);
        }
    }
}
