package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class w {
    private ViewGroup jwf;
    private ImageView jwg;
    private VideoLoadingProgressView jwh;
    ObjectAnimator jwi;
    ObjectAnimator jwj;
    ObjectAnimator jwk;

    public w(ViewGroup viewGroup) {
        this.jwf = viewGroup;
        this.jwg = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.jwh = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.jwi = ObjectAnimator.ofFloat(this.jwg, "alpha", 1.0f, 0.5f);
        this.jwj = ObjectAnimator.ofFloat(this.jwg, "alpha", 0.5f, 0.0f);
        this.jwk = ObjectAnimator.ofFloat(this.jwh, "alpha", 1.0f, 0.0f);
        this.jwi.setDuration(50L);
        this.jwj.setDuration(50L);
        this.jwk.setDuration(50L);
    }

    public void startLoading() {
        cancelAnimator();
        this.jwg.setAlpha(1.0f);
        this.jwh.setAlpha(1.0f);
        this.jwf.setVisibility(0);
        this.jwh.startLoading();
        this.jwi.start();
    }

    public void czl() {
        cancelAnimator();
        this.jwh.czl();
    }

    public void czm() {
        cancelAnimator();
        this.jwj.start();
        this.jwk.start();
    }

    public void czn() {
        cancelAnimator();
        this.jwf.setVisibility(8);
        this.jwh.czn();
    }

    private void cancelAnimator() {
        this.jwi.cancel();
        this.jwj.cancel();
        this.jwk.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.jwh != null) {
            this.jwh.setLoadingAnimationListener(aVar);
        }
    }
}
