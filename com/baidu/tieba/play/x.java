package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class x {
    private ViewGroup gEn;
    private ImageView gEo;
    private VideoLoadingProgressView gEp;
    ObjectAnimator gEq;
    ObjectAnimator gEr;
    ObjectAnimator gEs;

    public x(ViewGroup viewGroup) {
        this.gEn = viewGroup;
        this.gEo = (ImageView) viewGroup.findViewById(e.g.auto_video_loading_image);
        this.gEp = (VideoLoadingProgressView) viewGroup.findViewById(e.g.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.gEq = ObjectAnimator.ofFloat(this.gEo, "alpha", 1.0f, 0.5f);
        this.gEr = ObjectAnimator.ofFloat(this.gEo, "alpha", 0.5f, 0.0f);
        this.gEs = ObjectAnimator.ofFloat(this.gEp, "alpha", 1.0f, 0.0f);
        this.gEq.setDuration(50L);
        this.gEr.setDuration(50L);
        this.gEs.setDuration(50L);
    }

    public void startLoading() {
        bsa();
        this.gEo.setAlpha(1.0f);
        this.gEp.setAlpha(1.0f);
        this.gEn.setVisibility(0);
        this.gEp.startLoading();
        this.gEq.start();
    }

    public void brX() {
        bsa();
        this.gEp.brX();
    }

    public void brY() {
        bsa();
        this.gEr.start();
        this.gEs.start();
    }

    public void brZ() {
        bsa();
        this.gEn.setVisibility(8);
        this.gEp.brZ();
    }

    private void bsa() {
        this.gEq.cancel();
        this.gEr.cancel();
        this.gEs.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.gEp != null) {
            this.gEp.setLoadingAnimationListener(aVar);
        }
    }
}
