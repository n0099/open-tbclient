package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class y {
    private ViewGroup gEm;
    private ImageView gEn;
    private VideoLoadingProgressView gEo;
    ObjectAnimator gEp;
    ObjectAnimator gEq;
    ObjectAnimator gEr;

    public y(ViewGroup viewGroup) {
        this.gEm = viewGroup;
        this.gEn = (ImageView) viewGroup.findViewById(d.g.auto_video_loading_image);
        this.gEo = (VideoLoadingProgressView) viewGroup.findViewById(d.g.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.gEp = ObjectAnimator.ofFloat(this.gEn, "alpha", 1.0f, 0.5f);
        this.gEq = ObjectAnimator.ofFloat(this.gEn, "alpha", 0.5f, 0.0f);
        this.gEr = ObjectAnimator.ofFloat(this.gEo, "alpha", 1.0f, 0.0f);
        this.gEp.setDuration(300L);
        this.gEq.setDuration(300L);
        this.gEr.setDuration(300L);
    }

    public void startLoading() {
        brl();
        this.gEn.setAlpha(1.0f);
        this.gEo.setAlpha(1.0f);
        this.gEm.setVisibility(0);
        this.gEo.startLoading();
        this.gEp.start();
    }

    public void bri() {
        brl();
        this.gEo.bri();
    }

    public void brj() {
        brl();
        this.gEq.start();
        this.gEr.start();
    }

    public void brk() {
        brl();
        this.gEm.setVisibility(8);
        this.gEo.brk();
    }

    private void brl() {
        this.gEp.cancel();
        this.gEq.cancel();
        this.gEr.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.gEo != null) {
            this.gEo.setLoadingAnimationListener(aVar);
        }
    }
}
