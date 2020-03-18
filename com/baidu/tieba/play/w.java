package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class w {
    private ViewGroup jxS;
    private ImageView jxT;
    private VideoLoadingProgressView jxU;
    ObjectAnimator jxV;
    ObjectAnimator jxW;
    ObjectAnimator jxX;

    public w(ViewGroup viewGroup) {
        this.jxS = viewGroup;
        this.jxT = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.jxU = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.jxV = ObjectAnimator.ofFloat(this.jxT, "alpha", 1.0f, 0.5f);
        this.jxW = ObjectAnimator.ofFloat(this.jxT, "alpha", 0.5f, 0.0f);
        this.jxX = ObjectAnimator.ofFloat(this.jxU, "alpha", 1.0f, 0.0f);
        this.jxV.setDuration(50L);
        this.jxW.setDuration(50L);
        this.jxX.setDuration(50L);
    }

    public void startLoading() {
        cancelAnimator();
        this.jxT.setAlpha(1.0f);
        this.jxU.setAlpha(1.0f);
        this.jxS.setVisibility(0);
        this.jxU.startLoading();
        this.jxV.start();
    }

    public void czH() {
        cancelAnimator();
        this.jxU.czH();
    }

    public void czI() {
        cancelAnimator();
        this.jxW.start();
        this.jxX.start();
    }

    public void czJ() {
        cancelAnimator();
        this.jxS.setVisibility(8);
        this.jxU.czJ();
    }

    private void cancelAnimator() {
        this.jxV.cancel();
        this.jxW.cancel();
        this.jxX.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.jxU != null) {
            this.jxU.setLoadingAnimationListener(aVar);
        }
    }
}
