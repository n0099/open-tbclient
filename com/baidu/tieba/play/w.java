package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class w {
    private ViewGroup kzM;
    private ImageView kzN;
    private VideoLoadingProgressView kzO;
    ObjectAnimator kzP;
    ObjectAnimator kzQ;
    ObjectAnimator kzR;

    public w(ViewGroup viewGroup) {
        this.kzM = viewGroup;
        this.kzN = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.kzO = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.kzP = ObjectAnimator.ofFloat(this.kzN, "alpha", 1.0f, 0.5f);
        this.kzQ = ObjectAnimator.ofFloat(this.kzN, "alpha", 0.5f, 0.0f);
        this.kzR = ObjectAnimator.ofFloat(this.kzO, "alpha", 1.0f, 0.0f);
        this.kzP.setDuration(50L);
        this.kzQ.setDuration(50L);
        this.kzR.setDuration(50L);
    }

    public void startLoading() {
        cancelAnimator();
        this.kzN.setAlpha(1.0f);
        this.kzO.setAlpha(1.0f);
        this.kzM.setVisibility(0);
        this.kzO.startLoading();
        this.kzP.start();
    }

    public void cRj() {
        cancelAnimator();
        this.kzO.cRj();
    }

    public void cRk() {
        cancelAnimator();
        this.kzQ.start();
        this.kzR.start();
    }

    public void cRl() {
        cancelAnimator();
        this.kzM.setVisibility(8);
        this.kzO.cRl();
    }

    private void cancelAnimator() {
        this.kzP.cancel();
        this.kzQ.cancel();
        this.kzR.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.kzO != null) {
            this.kzO.setLoadingAnimationListener(aVar);
        }
    }
}
