package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class x {
    private ViewGroup gIj;
    private ImageView gIk;
    private VideoLoadingProgressView gIl;
    ObjectAnimator gIm;
    ObjectAnimator gIn;
    ObjectAnimator gIo;

    public x(ViewGroup viewGroup) {
        this.gIj = viewGroup;
        this.gIk = (ImageView) viewGroup.findViewById(e.g.auto_video_loading_image);
        this.gIl = (VideoLoadingProgressView) viewGroup.findViewById(e.g.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.gIm = ObjectAnimator.ofFloat(this.gIk, "alpha", 1.0f, 0.5f);
        this.gIn = ObjectAnimator.ofFloat(this.gIk, "alpha", 0.5f, 0.0f);
        this.gIo = ObjectAnimator.ofFloat(this.gIl, "alpha", 1.0f, 0.0f);
        this.gIm.setDuration(50L);
        this.gIn.setDuration(50L);
        this.gIo.setDuration(50L);
    }

    public void startLoading() {
        btu();
        this.gIk.setAlpha(1.0f);
        this.gIl.setAlpha(1.0f);
        this.gIj.setVisibility(0);
        this.gIl.startLoading();
        this.gIm.start();
    }

    public void btr() {
        btu();
        this.gIl.btr();
    }

    public void bts() {
        btu();
        this.gIn.start();
        this.gIo.start();
    }

    public void btt() {
        btu();
        this.gIj.setVisibility(8);
        this.gIl.btt();
    }

    private void btu() {
        this.gIm.cancel();
        this.gIn.cancel();
        this.gIo.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.gIl != null) {
            this.gIl.setLoadingAnimationListener(aVar);
        }
    }
}
