package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class y {
    private ImageView gvA;
    private VideoLoadingProgressView gvB;
    ObjectAnimator gvC;
    ObjectAnimator gvD;
    ObjectAnimator gvE;
    private ViewGroup gvz;

    public y(ViewGroup viewGroup) {
        this.gvz = viewGroup;
        this.gvA = (ImageView) viewGroup.findViewById(d.g.auto_video_loading_image);
        this.gvB = (VideoLoadingProgressView) viewGroup.findViewById(d.g.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.gvC = ObjectAnimator.ofFloat(this.gvA, "alpha", 1.0f, 0.5f);
        this.gvD = ObjectAnimator.ofFloat(this.gvA, "alpha", 0.5f, 0.0f);
        this.gvE = ObjectAnimator.ofFloat(this.gvB, "alpha", 1.0f, 0.0f);
        this.gvC.setDuration(300L);
        this.gvD.setDuration(300L);
        this.gvE.setDuration(300L);
    }

    public void startLoading() {
        blS();
        this.gvA.setAlpha(1.0f);
        this.gvB.setAlpha(1.0f);
        this.gvz.setVisibility(0);
        this.gvB.startLoading();
        this.gvC.start();
    }

    public void blP() {
        blS();
        this.gvB.blP();
    }

    public void blQ() {
        blS();
        this.gvD.start();
        this.gvE.start();
    }

    public void blR() {
        blS();
        this.gvz.setVisibility(8);
        this.gvB.blR();
    }

    private void blS() {
        this.gvC.cancel();
        this.gvD.cancel();
        this.gvE.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.gvB != null) {
            this.gvB.setLoadingAnimationListener(aVar);
        }
    }
}
