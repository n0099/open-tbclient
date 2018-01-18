package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class y {
    private ViewGroup gtt;
    private ImageView gtu;
    private VideoLoadingProgressView gtv;
    ObjectAnimator gtw;
    ObjectAnimator gtx;
    ObjectAnimator gty;

    public y(ViewGroup viewGroup) {
        this.gtt = viewGroup;
        this.gtu = (ImageView) viewGroup.findViewById(d.g.auto_video_loading_image);
        this.gtv = (VideoLoadingProgressView) viewGroup.findViewById(d.g.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.gtw = ObjectAnimator.ofFloat(this.gtu, "alpha", 1.0f, 0.5f);
        this.gtx = ObjectAnimator.ofFloat(this.gtu, "alpha", 0.5f, 0.0f);
        this.gty = ObjectAnimator.ofFloat(this.gtv, "alpha", 1.0f, 0.0f);
        this.gtw.setDuration(300L);
        this.gtx.setDuration(300L);
        this.gty.setDuration(300L);
    }

    public void startLoading() {
        bkE();
        this.gtu.setAlpha(1.0f);
        this.gtv.setAlpha(1.0f);
        this.gtt.setVisibility(0);
        this.gtv.startLoading();
        this.gtw.start();
    }

    public void bkB() {
        bkE();
        this.gtv.bkB();
    }

    public void bkC() {
        bkE();
        this.gtx.start();
        this.gty.start();
    }

    public void bkD() {
        bkE();
        this.gtt.setVisibility(8);
        this.gtv.bkD();
    }

    private void bkE() {
        this.gtw.cancel();
        this.gtx.cancel();
        this.gty.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.gtv != null) {
            this.gtv.setLoadingAnimationListener(aVar);
        }
    }
}
