package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class w {
    private ViewGroup fQi;
    private ImageView fQj;
    private VideoLoadingProgressView fQk;
    ObjectAnimator fQl;
    ObjectAnimator fQm;
    ObjectAnimator fQn;

    public w(ViewGroup viewGroup) {
        this.fQi = viewGroup;
        this.fQj = (ImageView) viewGroup.findViewById(d.g.auto_video_loading_image);
        this.fQk = (VideoLoadingProgressView) viewGroup.findViewById(d.g.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.fQl = ObjectAnimator.ofFloat(this.fQj, "alpha", 1.0f, 0.5f);
        this.fQm = ObjectAnimator.ofFloat(this.fQj, "alpha", 0.5f, 0.0f);
        this.fQn = ObjectAnimator.ofFloat(this.fQk, "alpha", 1.0f, 0.0f);
        this.fQl.setDuration(300L);
        this.fQm.setDuration(300L);
        this.fQn.setDuration(300L);
    }

    public void startLoading() {
        bgY();
        this.fQj.setAlpha(1.0f);
        this.fQk.setAlpha(1.0f);
        this.fQi.setVisibility(0);
        this.fQk.startLoading();
        this.fQl.start();
    }

    public void bgV() {
        bgY();
        this.fQk.bgV();
    }

    public void bgW() {
        bgY();
        this.fQm.start();
        this.fQn.start();
    }

    public void bgX() {
        bgY();
        this.fQi.setVisibility(8);
        this.fQk.bgX();
    }

    private void bgY() {
        this.fQl.cancel();
        this.fQm.cancel();
        this.fQn.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.fQk != null) {
            this.fQk.setLoadingAnimationListener(aVar);
        }
    }
}
