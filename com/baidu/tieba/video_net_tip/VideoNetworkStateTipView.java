package com.baidu.tieba.video_net_tip;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.video.g;
/* loaded from: classes.dex */
public class VideoNetworkStateTipView extends RelativeLayout {
    private TextView iao;
    private TextView iap;
    private TextView jfA;
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
        inflate(getContext(), d.h.video_network_state_tip, this);
        this.iao = (TextView) findViewById(d.g.play);
        this.iap = (TextView) findViewById(d.g.free_flow);
        this.iap.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video_net_tip.VideoNetworkStateTipView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.a(true, VideoNetworkStateTipView.this.getContext(), VideoNetworkStateTipView.this.getResources().getString(d.j.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
            }
        });
        this.jfA = (TextView) findViewById(d.g.play_tips);
        onChangeSkinType(TbadkApplication.getInst().getSkinType());
    }

    public boolean bUm() {
        return (hasAgreeToPlay() || g.ciM().ciN() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !j.la()) ? false : true;
    }

    public void cmm() {
        setVisibility(0);
        this.iao.setVisibility(0);
        this.iap.setVisibility(0);
        this.jfA.setVisibility(8);
    }

    public void cmn() {
        setVisibility(0);
        this.iao.setVisibility(8);
        this.iap.setVisibility(8);
        this.jfA.setVisibility(0);
        e.jH().removeCallbacks(this.mHideRunnable);
        e.jH().postDelayed(this.mHideRunnable, 3000L);
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
        this.iao.setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.j(this.iao, d.C0236d.cp_btn_a);
            al.k(this.iao, d.f.rectangle_background_alpha80);
            al.j(this.iap, d.C0236d.cp_btn_a);
            al.k(this.iap, d.f.blue_rectangle_background);
            al.j(this.jfA, d.C0236d.cp_btn_a);
            al.k(this.jfA, d.f.rectangle_background_alpha80);
        }
    }
}
