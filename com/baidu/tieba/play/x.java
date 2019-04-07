package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class x {
    private ViewGroup hXX;
    private ImageView hXY;
    private VideoLoadingProgressView hXZ;
    ObjectAnimator hYa;
    ObjectAnimator hYb;
    ObjectAnimator hYc;

    public x(ViewGroup viewGroup) {
        this.hXX = viewGroup;
        this.hXY = (ImageView) viewGroup.findViewById(d.g.auto_video_loading_image);
        this.hXZ = (VideoLoadingProgressView) viewGroup.findViewById(d.g.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.hYa = ObjectAnimator.ofFloat(this.hXY, "alpha", 1.0f, 0.5f);
        this.hYb = ObjectAnimator.ofFloat(this.hXY, "alpha", 0.5f, 0.0f);
        this.hYc = ObjectAnimator.ofFloat(this.hXZ, "alpha", 1.0f, 0.0f);
        this.hYa.setDuration(50L);
        this.hYb.setDuration(50L);
        this.hYc.setDuration(50L);
    }

    public void startLoading() {
        bTO();
        this.hXY.setAlpha(1.0f);
        this.hXZ.setAlpha(1.0f);
        this.hXX.setVisibility(0);
        this.hXZ.startLoading();
        this.hYa.start();
    }

    public void bTL() {
        bTO();
        this.hXZ.bTL();
    }

    public void bTM() {
        bTO();
        this.hYb.start();
        this.hYc.start();
    }

    public void bTN() {
        bTO();
        this.hXX.setVisibility(8);
        this.hXZ.bTN();
    }

    private void bTO() {
        this.hYa.cancel();
        this.hYb.cancel();
        this.hYc.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.hXZ != null) {
            this.hXZ.setLoadingAnimationListener(aVar);
        }
    }
}
