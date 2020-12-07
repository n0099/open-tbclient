package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class m {
    private ViewGroup mxP;
    private ImageView mxQ;
    private VideoLoadingProgressView mxR;
    ObjectAnimator mxS;
    ObjectAnimator mxT;
    ObjectAnimator mxU;

    public m(ViewGroup viewGroup) {
        this.mxP = viewGroup;
        this.mxQ = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.mxR = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.mxS = ObjectAnimator.ofFloat(this.mxQ, "alpha", 1.0f, 0.5f);
        this.mxT = ObjectAnimator.ofFloat(this.mxQ, "alpha", 0.5f, 0.0f);
        this.mxU = ObjectAnimator.ofFloat(this.mxR, "alpha", 1.0f, 0.0f);
        this.mxS.setDuration(50L);
        this.mxT.setDuration(50L);
        this.mxU.setDuration(50L);
    }

    public void startLoading() {
        dBW();
        this.mxQ.setAlpha(1.0f);
        this.mxR.setAlpha(1.0f);
        this.mxP.setVisibility(0);
        this.mxR.startLoading();
        this.mxS.start();
    }

    public void dBT() {
        dBW();
        this.mxR.dBT();
    }

    public void dBU() {
        dBW();
        this.mxT.start();
        this.mxU.start();
    }

    public void dBV() {
        dBW();
        this.mxP.setVisibility(8);
        this.mxR.dBV();
    }

    private void dBW() {
        this.mxS.cancel();
        this.mxT.cancel();
        this.mxU.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.mxR != null) {
            this.mxR.setLoadingAnimationListener(aVar);
        }
    }
}
