package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class w {
    private ViewGroup jrJ;
    private ImageView jrK;
    private VideoLoadingProgressView jrL;
    ObjectAnimator jrM;
    ObjectAnimator jrN;
    ObjectAnimator jrO;

    public w(ViewGroup viewGroup) {
        this.jrJ = viewGroup;
        this.jrK = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.jrL = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.jrM = ObjectAnimator.ofFloat(this.jrK, "alpha", 1.0f, 0.5f);
        this.jrN = ObjectAnimator.ofFloat(this.jrK, "alpha", 0.5f, 0.0f);
        this.jrO = ObjectAnimator.ofFloat(this.jrL, "alpha", 1.0f, 0.0f);
        this.jrM.setDuration(50L);
        this.jrN.setDuration(50L);
        this.jrO.setDuration(50L);
    }

    public void startLoading() {
        cancelAnimator();
        this.jrK.setAlpha(1.0f);
        this.jrL.setAlpha(1.0f);
        this.jrJ.setVisibility(0);
        this.jrL.startLoading();
        this.jrM.start();
    }

    public void cwI() {
        cancelAnimator();
        this.jrL.cwI();
    }

    public void cwJ() {
        cancelAnimator();
        this.jrN.start();
        this.jrO.start();
    }

    public void cwK() {
        cancelAnimator();
        this.jrJ.setVisibility(8);
        this.jrL.cwK();
    }

    private void cancelAnimator() {
        this.jrM.cancel();
        this.jrN.cancel();
        this.jrO.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.jrL != null) {
            this.jrL.setLoadingAnimationListener(aVar);
        }
    }
}
