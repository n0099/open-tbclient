package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class w {
    private ViewGroup gcA;
    private ImageView gcB;
    private VideoLoadingProgressView gcC;
    ObjectAnimator gcD;
    ObjectAnimator gcE;
    ObjectAnimator gcF;

    public w(ViewGroup viewGroup) {
        this.gcA = viewGroup;
        this.gcB = (ImageView) viewGroup.findViewById(d.g.auto_video_loading_image);
        this.gcC = (VideoLoadingProgressView) viewGroup.findViewById(d.g.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.gcD = ObjectAnimator.ofFloat(this.gcB, "alpha", 1.0f, 0.5f);
        this.gcE = ObjectAnimator.ofFloat(this.gcB, "alpha", 0.5f, 0.0f);
        this.gcF = ObjectAnimator.ofFloat(this.gcC, "alpha", 1.0f, 0.0f);
        this.gcD.setDuration(300L);
        this.gcE.setDuration(300L);
        this.gcF.setDuration(300L);
    }

    public void startLoading() {
        blW();
        this.gcB.setAlpha(1.0f);
        this.gcC.setAlpha(1.0f);
        this.gcA.setVisibility(0);
        this.gcC.startLoading();
        this.gcD.start();
    }

    public void blT() {
        blW();
        this.gcC.blT();
    }

    public void blU() {
        blW();
        this.gcE.start();
        this.gcF.start();
    }

    public void blV() {
        blW();
        this.gcA.setVisibility(8);
        this.gcC.blV();
    }

    private void blW() {
        this.gcD.cancel();
        this.gcE.cancel();
        this.gcF.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.gcC != null) {
            this.gcC.setLoadingAnimationListener(aVar);
        }
    }
}
