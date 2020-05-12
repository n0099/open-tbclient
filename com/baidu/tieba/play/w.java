package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class w {
    private ViewGroup khR;
    private ImageView khS;
    private VideoLoadingProgressView khT;
    ObjectAnimator khU;
    ObjectAnimator khV;
    ObjectAnimator khW;

    public w(ViewGroup viewGroup) {
        this.khR = viewGroup;
        this.khS = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.khT = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.khU = ObjectAnimator.ofFloat(this.khS, "alpha", 1.0f, 0.5f);
        this.khV = ObjectAnimator.ofFloat(this.khS, "alpha", 0.5f, 0.0f);
        this.khW = ObjectAnimator.ofFloat(this.khT, "alpha", 1.0f, 0.0f);
        this.khU.setDuration(50L);
        this.khV.setDuration(50L);
        this.khW.setDuration(50L);
    }

    public void startLoading() {
        cancelAnimator();
        this.khS.setAlpha(1.0f);
        this.khT.setAlpha(1.0f);
        this.khR.setVisibility(0);
        this.khT.startLoading();
        this.khU.start();
    }

    public void cKk() {
        cancelAnimator();
        this.khT.cKk();
    }

    public void cKl() {
        cancelAnimator();
        this.khV.start();
        this.khW.start();
    }

    public void cKm() {
        cancelAnimator();
        this.khR.setVisibility(8);
        this.khT.cKm();
    }

    private void cancelAnimator() {
        this.khU.cancel();
        this.khV.cancel();
        this.khW.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.khT != null) {
            this.khT.setLoadingAnimationListener(aVar);
        }
    }
}
