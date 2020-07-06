package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class w {
    private ViewGroup kUP;
    private ImageView kUQ;
    private VideoLoadingProgressView kUR;
    ObjectAnimator kUS;
    ObjectAnimator kUT;
    ObjectAnimator kUU;

    public w(ViewGroup viewGroup) {
        this.kUP = viewGroup;
        this.kUQ = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.kUR = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.kUS = ObjectAnimator.ofFloat(this.kUQ, "alpha", 1.0f, 0.5f);
        this.kUT = ObjectAnimator.ofFloat(this.kUQ, "alpha", 0.5f, 0.0f);
        this.kUU = ObjectAnimator.ofFloat(this.kUR, "alpha", 1.0f, 0.0f);
        this.kUS.setDuration(50L);
        this.kUT.setDuration(50L);
        this.kUU.setDuration(50L);
    }

    public void startLoading() {
        cancelAnimator();
        this.kUQ.setAlpha(1.0f);
        this.kUR.setAlpha(1.0f);
        this.kUP.setVisibility(0);
        this.kUR.startLoading();
        this.kUS.start();
    }

    public void cVR() {
        cancelAnimator();
        this.kUR.cVR();
    }

    public void cVS() {
        cancelAnimator();
        this.kUT.start();
        this.kUU.start();
    }

    public void cVT() {
        cancelAnimator();
        this.kUP.setVisibility(8);
        this.kUR.cVT();
    }

    private void cancelAnimator() {
        this.kUS.cancel();
        this.kUT.cancel();
        this.kUU.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.kUR != null) {
            this.kUR.setLoadingAnimationListener(aVar);
        }
    }
}
