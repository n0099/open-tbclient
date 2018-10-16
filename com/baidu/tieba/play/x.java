package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class x {
    private ViewGroup gvV;
    private ImageView gvW;
    private VideoLoadingProgressView gvX;
    ObjectAnimator gvY;
    ObjectAnimator gvZ;
    ObjectAnimator gwa;

    public x(ViewGroup viewGroup) {
        this.gvV = viewGroup;
        this.gvW = (ImageView) viewGroup.findViewById(e.g.auto_video_loading_image);
        this.gvX = (VideoLoadingProgressView) viewGroup.findViewById(e.g.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.gvY = ObjectAnimator.ofFloat(this.gvW, "alpha", 1.0f, 0.5f);
        this.gvZ = ObjectAnimator.ofFloat(this.gvW, "alpha", 0.5f, 0.0f);
        this.gwa = ObjectAnimator.ofFloat(this.gvX, "alpha", 1.0f, 0.0f);
        this.gvY.setDuration(50L);
        this.gvZ.setDuration(50L);
        this.gwa.setDuration(50L);
    }

    public void startLoading() {
        bqL();
        this.gvW.setAlpha(1.0f);
        this.gvX.setAlpha(1.0f);
        this.gvV.setVisibility(0);
        this.gvX.startLoading();
        this.gvY.start();
    }

    public void bqI() {
        bqL();
        this.gvX.bqI();
    }

    public void bqJ() {
        bqL();
        this.gvZ.start();
        this.gwa.start();
    }

    public void bqK() {
        bqL();
        this.gvV.setVisibility(8);
        this.gvX.bqK();
    }

    private void bqL() {
        this.gvY.cancel();
        this.gvZ.cancel();
        this.gwa.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.gvX != null) {
            this.gvX.setLoadingAnimationListener(aVar);
        }
    }
}
