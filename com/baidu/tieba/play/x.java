package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class x {
    private ViewGroup hXY;
    private ImageView hXZ;
    private VideoLoadingProgressView hYa;
    ObjectAnimator hYb;
    ObjectAnimator hYc;
    ObjectAnimator hYd;

    public x(ViewGroup viewGroup) {
        this.hXY = viewGroup;
        this.hXZ = (ImageView) viewGroup.findViewById(d.g.auto_video_loading_image);
        this.hYa = (VideoLoadingProgressView) viewGroup.findViewById(d.g.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.hYb = ObjectAnimator.ofFloat(this.hXZ, "alpha", 1.0f, 0.5f);
        this.hYc = ObjectAnimator.ofFloat(this.hXZ, "alpha", 0.5f, 0.0f);
        this.hYd = ObjectAnimator.ofFloat(this.hYa, "alpha", 1.0f, 0.0f);
        this.hYb.setDuration(50L);
        this.hYc.setDuration(50L);
        this.hYd.setDuration(50L);
    }

    public void startLoading() {
        bTO();
        this.hXZ.setAlpha(1.0f);
        this.hYa.setAlpha(1.0f);
        this.hXY.setVisibility(0);
        this.hYa.startLoading();
        this.hYb.start();
    }

    public void bTL() {
        bTO();
        this.hYa.bTL();
    }

    public void bTM() {
        bTO();
        this.hYc.start();
        this.hYd.start();
    }

    public void bTN() {
        bTO();
        this.hXY.setVisibility(8);
        this.hYa.bTN();
    }

    private void bTO() {
        this.hYb.cancel();
        this.hYc.cancel();
        this.hYd.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.hYa != null) {
            this.hYa.setLoadingAnimationListener(aVar);
        }
    }
}
