package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class m {
    private ViewGroup mxR;
    private ImageView mxS;
    private VideoLoadingProgressView mxT;
    ObjectAnimator mxU;
    ObjectAnimator mxV;
    ObjectAnimator mxW;

    public m(ViewGroup viewGroup) {
        this.mxR = viewGroup;
        this.mxS = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.mxT = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.mxU = ObjectAnimator.ofFloat(this.mxS, "alpha", 1.0f, 0.5f);
        this.mxV = ObjectAnimator.ofFloat(this.mxS, "alpha", 0.5f, 0.0f);
        this.mxW = ObjectAnimator.ofFloat(this.mxT, "alpha", 1.0f, 0.0f);
        this.mxU.setDuration(50L);
        this.mxV.setDuration(50L);
        this.mxW.setDuration(50L);
    }

    public void startLoading() {
        dBX();
        this.mxS.setAlpha(1.0f);
        this.mxT.setAlpha(1.0f);
        this.mxR.setVisibility(0);
        this.mxT.startLoading();
        this.mxU.start();
    }

    public void dBU() {
        dBX();
        this.mxT.dBU();
    }

    public void dBV() {
        dBX();
        this.mxV.start();
        this.mxW.start();
    }

    public void dBW() {
        dBX();
        this.mxR.setVisibility(8);
        this.mxT.dBW();
    }

    private void dBX() {
        this.mxU.cancel();
        this.mxV.cancel();
        this.mxW.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.mxT != null) {
            this.mxT.setLoadingAnimationListener(aVar);
        }
    }
}
