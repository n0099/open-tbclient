package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class x {
    private ViewGroup gIi;
    private ImageView gIj;
    private VideoLoadingProgressView gIk;
    ObjectAnimator gIl;
    ObjectAnimator gIm;
    ObjectAnimator gIn;

    public x(ViewGroup viewGroup) {
        this.gIi = viewGroup;
        this.gIj = (ImageView) viewGroup.findViewById(e.g.auto_video_loading_image);
        this.gIk = (VideoLoadingProgressView) viewGroup.findViewById(e.g.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.gIl = ObjectAnimator.ofFloat(this.gIj, "alpha", 1.0f, 0.5f);
        this.gIm = ObjectAnimator.ofFloat(this.gIj, "alpha", 0.5f, 0.0f);
        this.gIn = ObjectAnimator.ofFloat(this.gIk, "alpha", 1.0f, 0.0f);
        this.gIl.setDuration(50L);
        this.gIm.setDuration(50L);
        this.gIn.setDuration(50L);
    }

    public void startLoading() {
        btu();
        this.gIj.setAlpha(1.0f);
        this.gIk.setAlpha(1.0f);
        this.gIi.setVisibility(0);
        this.gIk.startLoading();
        this.gIl.start();
    }

    public void btr() {
        btu();
        this.gIk.btr();
    }

    public void bts() {
        btu();
        this.gIm.start();
        this.gIn.start();
    }

    public void btt() {
        btu();
        this.gIi.setVisibility(8);
        this.gIk.btt();
    }

    private void btu() {
        this.gIl.cancel();
        this.gIm.cancel();
        this.gIn.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.gIk != null) {
            this.gIk.setLoadingAnimationListener(aVar);
        }
    }
}
