package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class x {
    private ViewGroup hYq;
    private ImageView hYr;
    private VideoLoadingProgressView hYs;
    ObjectAnimator hYt;
    ObjectAnimator hYu;
    ObjectAnimator hYv;

    public x(ViewGroup viewGroup) {
        this.hYq = viewGroup;
        this.hYr = (ImageView) viewGroup.findViewById(d.g.auto_video_loading_image);
        this.hYs = (VideoLoadingProgressView) viewGroup.findViewById(d.g.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.hYt = ObjectAnimator.ofFloat(this.hYr, "alpha", 1.0f, 0.5f);
        this.hYu = ObjectAnimator.ofFloat(this.hYr, "alpha", 0.5f, 0.0f);
        this.hYv = ObjectAnimator.ofFloat(this.hYs, "alpha", 1.0f, 0.0f);
        this.hYt.setDuration(50L);
        this.hYu.setDuration(50L);
        this.hYv.setDuration(50L);
    }

    public void startLoading() {
        bTP();
        this.hYr.setAlpha(1.0f);
        this.hYs.setAlpha(1.0f);
        this.hYq.setVisibility(0);
        this.hYs.startLoading();
        this.hYt.start();
    }

    public void bTM() {
        bTP();
        this.hYs.bTM();
    }

    public void bTN() {
        bTP();
        this.hYu.start();
        this.hYv.start();
    }

    public void bTO() {
        bTP();
        this.hYq.setVisibility(8);
        this.hYs.bTO();
    }

    private void bTP() {
        this.hYt.cancel();
        this.hYu.cancel();
        this.hYv.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.hYs != null) {
            this.hYs.setLoadingAnimationListener(aVar);
        }
    }
}
