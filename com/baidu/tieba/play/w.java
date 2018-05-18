package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class w {
    private ViewGroup fRo;
    private ImageView fRp;
    private VideoLoadingProgressView fRq;
    ObjectAnimator fRr;
    ObjectAnimator fRs;
    ObjectAnimator fRt;

    public w(ViewGroup viewGroup) {
        this.fRo = viewGroup;
        this.fRp = (ImageView) viewGroup.findViewById(d.g.auto_video_loading_image);
        this.fRq = (VideoLoadingProgressView) viewGroup.findViewById(d.g.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.fRr = ObjectAnimator.ofFloat(this.fRp, "alpha", 1.0f, 0.5f);
        this.fRs = ObjectAnimator.ofFloat(this.fRp, "alpha", 0.5f, 0.0f);
        this.fRt = ObjectAnimator.ofFloat(this.fRq, "alpha", 1.0f, 0.0f);
        this.fRr.setDuration(300L);
        this.fRs.setDuration(300L);
        this.fRt.setDuration(300L);
    }

    public void startLoading() {
        bgY();
        this.fRp.setAlpha(1.0f);
        this.fRq.setAlpha(1.0f);
        this.fRo.setVisibility(0);
        this.fRq.startLoading();
        this.fRr.start();
    }

    public void bgV() {
        bgY();
        this.fRq.bgV();
    }

    public void bgW() {
        bgY();
        this.fRs.start();
        this.fRt.start();
    }

    public void bgX() {
        bgY();
        this.fRo.setVisibility(8);
        this.fRq.bgX();
    }

    private void bgY() {
        this.fRr.cancel();
        this.fRs.cancel();
        this.fRt.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.fRq != null) {
            this.fRq.setLoadingAnimationListener(aVar);
        }
    }
}
