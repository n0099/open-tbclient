package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class w {
    private ViewGroup ghb;
    private ImageView ghc;
    private VideoLoadingProgressView ghd;
    ObjectAnimator ghe;
    ObjectAnimator ghf;
    ObjectAnimator ghg;

    public w(ViewGroup viewGroup) {
        this.ghb = viewGroup;
        this.ghc = (ImageView) viewGroup.findViewById(d.g.auto_video_loading_image);
        this.ghd = (VideoLoadingProgressView) viewGroup.findViewById(d.g.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.ghe = ObjectAnimator.ofFloat(this.ghc, "alpha", 1.0f, 0.5f);
        this.ghf = ObjectAnimator.ofFloat(this.ghc, "alpha", 0.5f, 0.0f);
        this.ghg = ObjectAnimator.ofFloat(this.ghd, "alpha", 1.0f, 0.0f);
        this.ghe.setDuration(300L);
        this.ghf.setDuration(300L);
        this.ghg.setDuration(300L);
    }

    public void startLoading() {
        bkT();
        this.ghc.setAlpha(1.0f);
        this.ghd.setAlpha(1.0f);
        this.ghb.setVisibility(0);
        this.ghd.startLoading();
        this.ghe.start();
    }

    public void bkQ() {
        bkT();
        this.ghd.bkQ();
    }

    public void bkR() {
        bkT();
        this.ghf.start();
        this.ghg.start();
    }

    public void bkS() {
        bkT();
        this.ghb.setVisibility(8);
        this.ghd.bkS();
    }

    private void bkT() {
        this.ghe.cancel();
        this.ghf.cancel();
        this.ghg.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.ghd != null) {
            this.ghd.setLoadingAnimationListener(aVar);
        }
    }
}
