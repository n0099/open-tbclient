package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class x {
    private ViewGroup hYl;
    private ImageView hYm;
    private VideoLoadingProgressView hYn;
    ObjectAnimator hYo;
    ObjectAnimator hYp;
    ObjectAnimator hYq;

    public x(ViewGroup viewGroup) {
        this.hYl = viewGroup;
        this.hYm = (ImageView) viewGroup.findViewById(d.g.auto_video_loading_image);
        this.hYn = (VideoLoadingProgressView) viewGroup.findViewById(d.g.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.hYo = ObjectAnimator.ofFloat(this.hYm, "alpha", 1.0f, 0.5f);
        this.hYp = ObjectAnimator.ofFloat(this.hYm, "alpha", 0.5f, 0.0f);
        this.hYq = ObjectAnimator.ofFloat(this.hYn, "alpha", 1.0f, 0.0f);
        this.hYo.setDuration(50L);
        this.hYp.setDuration(50L);
        this.hYq.setDuration(50L);
    }

    public void startLoading() {
        bTS();
        this.hYm.setAlpha(1.0f);
        this.hYn.setAlpha(1.0f);
        this.hYl.setVisibility(0);
        this.hYn.startLoading();
        this.hYo.start();
    }

    public void bTP() {
        bTS();
        this.hYn.bTP();
    }

    public void bTQ() {
        bTS();
        this.hYp.start();
        this.hYq.start();
    }

    public void bTR() {
        bTS();
        this.hYl.setVisibility(8);
        this.hYn.bTR();
    }

    private void bTS() {
        this.hYo.cancel();
        this.hYp.cancel();
        this.hYq.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.hYn != null) {
            this.hYn.setLoadingAnimationListener(aVar);
        }
    }
}
