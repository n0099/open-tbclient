package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class w {
    private ViewGroup jvp;
    private ImageView jvq;
    private VideoLoadingProgressView jvr;
    ObjectAnimator jvs;
    ObjectAnimator jvt;
    ObjectAnimator jvu;

    public w(ViewGroup viewGroup) {
        this.jvp = viewGroup;
        this.jvq = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.jvr = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.jvs = ObjectAnimator.ofFloat(this.jvq, "alpha", 1.0f, 0.5f);
        this.jvt = ObjectAnimator.ofFloat(this.jvq, "alpha", 0.5f, 0.0f);
        this.jvu = ObjectAnimator.ofFloat(this.jvr, "alpha", 1.0f, 0.0f);
        this.jvs.setDuration(50L);
        this.jvt.setDuration(50L);
        this.jvu.setDuration(50L);
    }

    public void startLoading() {
        cancelAnimator();
        this.jvq.setAlpha(1.0f);
        this.jvr.setAlpha(1.0f);
        this.jvp.setVisibility(0);
        this.jvr.startLoading();
        this.jvs.start();
    }

    public void cxR() {
        cancelAnimator();
        this.jvr.cxR();
    }

    public void cxS() {
        cancelAnimator();
        this.jvt.start();
        this.jvu.start();
    }

    public void cxT() {
        cancelAnimator();
        this.jvp.setVisibility(8);
        this.jvr.cxT();
    }

    private void cancelAnimator() {
        this.jvs.cancel();
        this.jvt.cancel();
        this.jvu.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.jvr != null) {
            this.jvr.setLoadingAnimationListener(aVar);
        }
    }
}
