package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class x {
    private ViewGroup gHe;
    private ImageView gHf;
    private VideoLoadingProgressView gHg;
    ObjectAnimator gHh;
    ObjectAnimator gHi;
    ObjectAnimator gHj;

    public x(ViewGroup viewGroup) {
        this.gHe = viewGroup;
        this.gHf = (ImageView) viewGroup.findViewById(e.g.auto_video_loading_image);
        this.gHg = (VideoLoadingProgressView) viewGroup.findViewById(e.g.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.gHh = ObjectAnimator.ofFloat(this.gHf, "alpha", 1.0f, 0.5f);
        this.gHi = ObjectAnimator.ofFloat(this.gHf, "alpha", 0.5f, 0.0f);
        this.gHj = ObjectAnimator.ofFloat(this.gHg, "alpha", 1.0f, 0.0f);
        this.gHh.setDuration(50L);
        this.gHi.setDuration(50L);
        this.gHj.setDuration(50L);
    }

    public void startLoading() {
        bsL();
        this.gHf.setAlpha(1.0f);
        this.gHg.setAlpha(1.0f);
        this.gHe.setVisibility(0);
        this.gHg.startLoading();
        this.gHh.start();
    }

    public void bsI() {
        bsL();
        this.gHg.bsI();
    }

    public void bsJ() {
        bsL();
        this.gHi.start();
        this.gHj.start();
    }

    public void bsK() {
        bsL();
        this.gHe.setVisibility(8);
        this.gHg.bsK();
    }

    private void bsL() {
        this.gHh.cancel();
        this.gHi.cancel();
        this.gHj.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.gHg != null) {
            this.gHg.setLoadingAnimationListener(aVar);
        }
    }
}
