package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class w {
    private ViewGroup khN;
    private ImageView khO;
    private VideoLoadingProgressView khP;
    ObjectAnimator khQ;
    ObjectAnimator khR;
    ObjectAnimator khS;

    public w(ViewGroup viewGroup) {
        this.khN = viewGroup;
        this.khO = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.khP = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.khQ = ObjectAnimator.ofFloat(this.khO, "alpha", 1.0f, 0.5f);
        this.khR = ObjectAnimator.ofFloat(this.khO, "alpha", 0.5f, 0.0f);
        this.khS = ObjectAnimator.ofFloat(this.khP, "alpha", 1.0f, 0.0f);
        this.khQ.setDuration(50L);
        this.khR.setDuration(50L);
        this.khS.setDuration(50L);
    }

    public void startLoading() {
        cancelAnimator();
        this.khO.setAlpha(1.0f);
        this.khP.setAlpha(1.0f);
        this.khN.setVisibility(0);
        this.khP.startLoading();
        this.khQ.start();
    }

    public void cKm() {
        cancelAnimator();
        this.khP.cKm();
    }

    public void cKn() {
        cancelAnimator();
        this.khR.start();
        this.khS.start();
    }

    public void cKo() {
        cancelAnimator();
        this.khN.setVisibility(8);
        this.khP.cKo();
    }

    private void cancelAnimator() {
        this.khQ.cancel();
        this.khR.cancel();
        this.khS.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.khP != null) {
            this.khP.setLoadingAnimationListener(aVar);
        }
    }
}
