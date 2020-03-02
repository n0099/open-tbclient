package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class w {
    private ViewGroup jwh;
    private ImageView jwi;
    private VideoLoadingProgressView jwj;
    ObjectAnimator jwk;
    ObjectAnimator jwl;
    ObjectAnimator jwm;

    public w(ViewGroup viewGroup) {
        this.jwh = viewGroup;
        this.jwi = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.jwj = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.jwk = ObjectAnimator.ofFloat(this.jwi, "alpha", 1.0f, 0.5f);
        this.jwl = ObjectAnimator.ofFloat(this.jwi, "alpha", 0.5f, 0.0f);
        this.jwm = ObjectAnimator.ofFloat(this.jwj, "alpha", 1.0f, 0.0f);
        this.jwk.setDuration(50L);
        this.jwl.setDuration(50L);
        this.jwm.setDuration(50L);
    }

    public void startLoading() {
        cancelAnimator();
        this.jwi.setAlpha(1.0f);
        this.jwj.setAlpha(1.0f);
        this.jwh.setVisibility(0);
        this.jwj.startLoading();
        this.jwk.start();
    }

    public void czn() {
        cancelAnimator();
        this.jwj.czn();
    }

    public void czo() {
        cancelAnimator();
        this.jwl.start();
        this.jwm.start();
    }

    public void czp() {
        cancelAnimator();
        this.jwh.setVisibility(8);
        this.jwj.czp();
    }

    private void cancelAnimator() {
        this.jwk.cancel();
        this.jwl.cancel();
        this.jwm.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.jwj != null) {
            this.jwj.setLoadingAnimationListener(aVar);
        }
    }
}
