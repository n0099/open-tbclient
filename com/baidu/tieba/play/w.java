package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class w {
    private ViewGroup ggB;
    private ImageView ggC;
    private VideoLoadingProgressView ggD;
    ObjectAnimator ggE;
    ObjectAnimator ggF;
    ObjectAnimator ggG;

    public w(ViewGroup viewGroup) {
        this.ggB = viewGroup;
        this.ggC = (ImageView) viewGroup.findViewById(d.g.auto_video_loading_image);
        this.ggD = (VideoLoadingProgressView) viewGroup.findViewById(d.g.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.ggE = ObjectAnimator.ofFloat(this.ggC, "alpha", 1.0f, 0.5f);
        this.ggF = ObjectAnimator.ofFloat(this.ggC, "alpha", 0.5f, 0.0f);
        this.ggG = ObjectAnimator.ofFloat(this.ggD, "alpha", 1.0f, 0.0f);
        this.ggE.setDuration(300L);
        this.ggF.setDuration(300L);
        this.ggG.setDuration(300L);
    }

    public void startLoading() {
        bmA();
        this.ggC.setAlpha(1.0f);
        this.ggD.setAlpha(1.0f);
        this.ggB.setVisibility(0);
        this.ggD.startLoading();
        this.ggE.start();
    }

    public void bmx() {
        bmA();
        this.ggD.bmx();
    }

    public void bmy() {
        bmA();
        this.ggF.start();
        this.ggG.start();
    }

    public void bmz() {
        bmA();
        this.ggB.setVisibility(8);
        this.ggD.bmz();
    }

    private void bmA() {
        this.ggE.cancel();
        this.ggF.cancel();
        this.ggG.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.ggD != null) {
            this.ggD.setLoadingAnimationListener(aVar);
        }
    }
}
