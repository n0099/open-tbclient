package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class x {
    private ViewGroup gvW;
    private ImageView gvX;
    private VideoLoadingProgressView gvY;
    ObjectAnimator gvZ;
    ObjectAnimator gwa;
    ObjectAnimator gwb;

    public x(ViewGroup viewGroup) {
        this.gvW = viewGroup;
        this.gvX = (ImageView) viewGroup.findViewById(e.g.auto_video_loading_image);
        this.gvY = (VideoLoadingProgressView) viewGroup.findViewById(e.g.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.gvZ = ObjectAnimator.ofFloat(this.gvX, "alpha", 1.0f, 0.5f);
        this.gwa = ObjectAnimator.ofFloat(this.gvX, "alpha", 0.5f, 0.0f);
        this.gwb = ObjectAnimator.ofFloat(this.gvY, "alpha", 1.0f, 0.0f);
        this.gvZ.setDuration(50L);
        this.gwa.setDuration(50L);
        this.gwb.setDuration(50L);
    }

    public void startLoading() {
        bqL();
        this.gvX.setAlpha(1.0f);
        this.gvY.setAlpha(1.0f);
        this.gvW.setVisibility(0);
        this.gvY.startLoading();
        this.gvZ.start();
    }

    public void bqI() {
        bqL();
        this.gvY.bqI();
    }

    public void bqJ() {
        bqL();
        this.gwa.start();
        this.gwb.start();
    }

    public void bqK() {
        bqL();
        this.gvW.setVisibility(8);
        this.gvY.bqK();
    }

    private void bqL() {
        this.gvZ.cancel();
        this.gwa.cancel();
        this.gwb.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.gvY != null) {
            this.gvY.setLoadingAnimationListener(aVar);
        }
    }
}
