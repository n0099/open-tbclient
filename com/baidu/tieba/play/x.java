package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class x {
    private ViewGroup hYr;
    private ImageView hYs;
    private VideoLoadingProgressView hYt;
    ObjectAnimator hYu;
    ObjectAnimator hYv;
    ObjectAnimator hYw;

    public x(ViewGroup viewGroup) {
        this.hYr = viewGroup;
        this.hYs = (ImageView) viewGroup.findViewById(d.g.auto_video_loading_image);
        this.hYt = (VideoLoadingProgressView) viewGroup.findViewById(d.g.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.hYu = ObjectAnimator.ofFloat(this.hYs, "alpha", 1.0f, 0.5f);
        this.hYv = ObjectAnimator.ofFloat(this.hYs, "alpha", 0.5f, 0.0f);
        this.hYw = ObjectAnimator.ofFloat(this.hYt, "alpha", 1.0f, 0.0f);
        this.hYu.setDuration(50L);
        this.hYv.setDuration(50L);
        this.hYw.setDuration(50L);
    }

    public void startLoading() {
        bTQ();
        this.hYs.setAlpha(1.0f);
        this.hYt.setAlpha(1.0f);
        this.hYr.setVisibility(0);
        this.hYt.startLoading();
        this.hYu.start();
    }

    public void bTN() {
        bTQ();
        this.hYt.bTN();
    }

    public void bTO() {
        bTQ();
        this.hYv.start();
        this.hYw.start();
    }

    public void bTP() {
        bTQ();
        this.hYr.setVisibility(8);
        this.hYt.bTP();
    }

    private void bTQ() {
        this.hYu.cancel();
        this.hYv.cancel();
        this.hYw.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.hYt != null) {
            this.hYt.setLoadingAnimationListener(aVar);
        }
    }
}
