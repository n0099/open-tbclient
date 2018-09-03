package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.f;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class w {
    private ViewGroup gha;
    private ImageView ghb;
    private VideoLoadingProgressView ghc;
    ObjectAnimator ghd;
    ObjectAnimator ghe;
    ObjectAnimator ghf;

    public w(ViewGroup viewGroup) {
        this.gha = viewGroup;
        this.ghb = (ImageView) viewGroup.findViewById(f.g.auto_video_loading_image);
        this.ghc = (VideoLoadingProgressView) viewGroup.findViewById(f.g.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.ghd = ObjectAnimator.ofFloat(this.ghb, "alpha", 1.0f, 0.5f);
        this.ghe = ObjectAnimator.ofFloat(this.ghb, "alpha", 0.5f, 0.0f);
        this.ghf = ObjectAnimator.ofFloat(this.ghc, "alpha", 1.0f, 0.0f);
        this.ghd.setDuration(300L);
        this.ghe.setDuration(300L);
        this.ghf.setDuration(300L);
    }

    public void startLoading() {
        bkQ();
        this.ghb.setAlpha(1.0f);
        this.ghc.setAlpha(1.0f);
        this.gha.setVisibility(0);
        this.ghc.startLoading();
        this.ghd.start();
    }

    public void bkN() {
        bkQ();
        this.ghc.bkN();
    }

    public void bkO() {
        bkQ();
        this.ghe.start();
        this.ghf.start();
    }

    public void bkP() {
        bkQ();
        this.gha.setVisibility(8);
        this.ghc.bkP();
    }

    private void bkQ() {
        this.ghd.cancel();
        this.ghe.cancel();
        this.ghf.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.ghc != null) {
            this.ghc.setLoadingAnimationListener(aVar);
        }
    }
}
