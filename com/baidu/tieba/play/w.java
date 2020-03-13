package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class w {
    private ViewGroup jwt;
    private ImageView jwu;
    private VideoLoadingProgressView jwv;
    ObjectAnimator jww;
    ObjectAnimator jwx;
    ObjectAnimator jwy;

    public w(ViewGroup viewGroup) {
        this.jwt = viewGroup;
        this.jwu = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.jwv = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.jww = ObjectAnimator.ofFloat(this.jwu, "alpha", 1.0f, 0.5f);
        this.jwx = ObjectAnimator.ofFloat(this.jwu, "alpha", 0.5f, 0.0f);
        this.jwy = ObjectAnimator.ofFloat(this.jwv, "alpha", 1.0f, 0.0f);
        this.jww.setDuration(50L);
        this.jwx.setDuration(50L);
        this.jwy.setDuration(50L);
    }

    public void startLoading() {
        cancelAnimator();
        this.jwu.setAlpha(1.0f);
        this.jwv.setAlpha(1.0f);
        this.jwt.setVisibility(0);
        this.jwv.startLoading();
        this.jww.start();
    }

    public void czo() {
        cancelAnimator();
        this.jwv.czo();
    }

    public void czp() {
        cancelAnimator();
        this.jwx.start();
        this.jwy.start();
    }

    public void czq() {
        cancelAnimator();
        this.jwt.setVisibility(8);
        this.jwv.czq();
    }

    private void cancelAnimator() {
        this.jww.cancel();
        this.jwx.cancel();
        this.jwy.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.jwv != null) {
            this.jwv.setLoadingAnimationListener(aVar);
        }
    }
}
