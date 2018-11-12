package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class x {
    ObjectAnimator gxA;
    ObjectAnimator gxB;
    ObjectAnimator gxC;
    private ViewGroup gxx;
    private ImageView gxy;
    private VideoLoadingProgressView gxz;

    public x(ViewGroup viewGroup) {
        this.gxx = viewGroup;
        this.gxy = (ImageView) viewGroup.findViewById(e.g.auto_video_loading_image);
        this.gxz = (VideoLoadingProgressView) viewGroup.findViewById(e.g.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.gxA = ObjectAnimator.ofFloat(this.gxy, "alpha", 1.0f, 0.5f);
        this.gxB = ObjectAnimator.ofFloat(this.gxy, "alpha", 0.5f, 0.0f);
        this.gxC = ObjectAnimator.ofFloat(this.gxz, "alpha", 1.0f, 0.0f);
        this.gxA.setDuration(50L);
        this.gxB.setDuration(50L);
        this.gxC.setDuration(50L);
    }

    public void startLoading() {
        bqh();
        this.gxy.setAlpha(1.0f);
        this.gxz.setAlpha(1.0f);
        this.gxx.setVisibility(0);
        this.gxz.startLoading();
        this.gxA.start();
    }

    public void bqe() {
        bqh();
        this.gxz.bqe();
    }

    public void bqf() {
        bqh();
        this.gxB.start();
        this.gxC.start();
    }

    public void bqg() {
        bqh();
        this.gxx.setVisibility(8);
        this.gxz.bqg();
    }

    private void bqh() {
        this.gxA.cancel();
        this.gxB.cancel();
        this.gxC.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.gxz != null) {
            this.gxz.setLoadingAnimationListener(aVar);
        }
    }
}
