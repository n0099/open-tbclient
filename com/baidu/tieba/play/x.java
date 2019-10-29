package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class x {
    private ViewGroup iyA;
    private ImageView iyB;
    private VideoLoadingProgressView iyC;
    ObjectAnimator iyD;
    ObjectAnimator iyE;
    ObjectAnimator iyF;

    public x(ViewGroup viewGroup) {
        this.iyA = viewGroup;
        this.iyB = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.iyC = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.iyD = ObjectAnimator.ofFloat(this.iyB, "alpha", 1.0f, 0.5f);
        this.iyE = ObjectAnimator.ofFloat(this.iyB, "alpha", 0.5f, 0.0f);
        this.iyF = ObjectAnimator.ofFloat(this.iyC, "alpha", 1.0f, 0.0f);
        this.iyD.setDuration(50L);
        this.iyE.setDuration(50L);
        this.iyF.setDuration(50L);
    }

    public void startLoading() {
        ccQ();
        this.iyB.setAlpha(1.0f);
        this.iyC.setAlpha(1.0f);
        this.iyA.setVisibility(0);
        this.iyC.startLoading();
        this.iyD.start();
    }

    public void ccN() {
        ccQ();
        this.iyC.ccN();
    }

    public void ccO() {
        ccQ();
        this.iyE.start();
        this.iyF.start();
    }

    public void ccP() {
        ccQ();
        this.iyA.setVisibility(8);
        this.iyC.ccP();
    }

    private void ccQ() {
        this.iyD.cancel();
        this.iyE.cancel();
        this.iyF.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.iyC != null) {
            this.iyC.setLoadingAnimationListener(aVar);
        }
    }
}
