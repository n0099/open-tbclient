package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class w {
    private ViewGroup kAS;
    private ImageView kAT;
    private VideoLoadingProgressView kAU;
    ObjectAnimator kAV;
    ObjectAnimator kAW;
    ObjectAnimator kAX;

    public w(ViewGroup viewGroup) {
        this.kAS = viewGroup;
        this.kAT = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.kAU = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.kAV = ObjectAnimator.ofFloat(this.kAT, "alpha", 1.0f, 0.5f);
        this.kAW = ObjectAnimator.ofFloat(this.kAT, "alpha", 0.5f, 0.0f);
        this.kAX = ObjectAnimator.ofFloat(this.kAU, "alpha", 1.0f, 0.0f);
        this.kAV.setDuration(50L);
        this.kAW.setDuration(50L);
        this.kAX.setDuration(50L);
    }

    public void startLoading() {
        cancelAnimator();
        this.kAT.setAlpha(1.0f);
        this.kAU.setAlpha(1.0f);
        this.kAS.setVisibility(0);
        this.kAU.startLoading();
        this.kAV.start();
    }

    public void cRz() {
        cancelAnimator();
        this.kAU.cRz();
    }

    public void cRA() {
        cancelAnimator();
        this.kAW.start();
        this.kAX.start();
    }

    public void cRB() {
        cancelAnimator();
        this.kAS.setVisibility(8);
        this.kAU.cRB();
    }

    private void cancelAnimator() {
        this.kAV.cancel();
        this.kAW.cancel();
        this.kAX.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.kAU != null) {
            this.kAU.setLoadingAnimationListener(aVar);
        }
    }
}
