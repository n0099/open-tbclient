package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class m {
    private ViewGroup lQV;
    private ImageView lQW;
    private VideoLoadingProgressView lQX;
    ObjectAnimator lQY;
    ObjectAnimator lQZ;
    ObjectAnimator lRa;

    public m(ViewGroup viewGroup) {
        this.lQV = viewGroup;
        this.lQW = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.lQX = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.lQY = ObjectAnimator.ofFloat(this.lQW, "alpha", 1.0f, 0.5f);
        this.lQZ = ObjectAnimator.ofFloat(this.lQW, "alpha", 0.5f, 0.0f);
        this.lRa = ObjectAnimator.ofFloat(this.lQX, "alpha", 1.0f, 0.0f);
        this.lQY.setDuration(50L);
        this.lQZ.setDuration(50L);
        this.lRa.setDuration(50L);
    }

    public void startLoading() {
        drv();
        this.lQW.setAlpha(1.0f);
        this.lQX.setAlpha(1.0f);
        this.lQV.setVisibility(0);
        this.lQX.startLoading();
        this.lQY.start();
    }

    public void drs() {
        drv();
        this.lQX.drs();
    }

    public void drt() {
        drv();
        this.lQZ.start();
        this.lRa.start();
    }

    public void dru() {
        drv();
        this.lQV.setVisibility(8);
        this.lQX.dru();
    }

    private void drv() {
        this.lQY.cancel();
        this.lQZ.cancel();
        this.lRa.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.lQX != null) {
            this.lQX.setLoadingAnimationListener(aVar);
        }
    }
}
