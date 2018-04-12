package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class w {
    private ViewGroup fQl;
    private ImageView fQm;
    private VideoLoadingProgressView fQn;
    ObjectAnimator fQo;
    ObjectAnimator fQp;
    ObjectAnimator fQq;

    public w(ViewGroup viewGroup) {
        this.fQl = viewGroup;
        this.fQm = (ImageView) viewGroup.findViewById(d.g.auto_video_loading_image);
        this.fQn = (VideoLoadingProgressView) viewGroup.findViewById(d.g.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.fQo = ObjectAnimator.ofFloat(this.fQm, "alpha", 1.0f, 0.5f);
        this.fQp = ObjectAnimator.ofFloat(this.fQm, "alpha", 0.5f, 0.0f);
        this.fQq = ObjectAnimator.ofFloat(this.fQn, "alpha", 1.0f, 0.0f);
        this.fQo.setDuration(300L);
        this.fQp.setDuration(300L);
        this.fQq.setDuration(300L);
    }

    public void startLoading() {
        bgY();
        this.fQm.setAlpha(1.0f);
        this.fQn.setAlpha(1.0f);
        this.fQl.setVisibility(0);
        this.fQn.startLoading();
        this.fQo.start();
    }

    public void bgV() {
        bgY();
        this.fQn.bgV();
    }

    public void bgW() {
        bgY();
        this.fQp.start();
        this.fQq.start();
    }

    public void bgX() {
        bgY();
        this.fQl.setVisibility(8);
        this.fQn.bgX();
    }

    private void bgY() {
        this.fQo.cancel();
        this.fQp.cancel();
        this.fQq.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.fQn != null) {
            this.fQn.setLoadingAnimationListener(aVar);
        }
    }
}
