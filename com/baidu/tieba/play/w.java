package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class w {
    private ViewGroup jvk;
    private ImageView jvl;
    private VideoLoadingProgressView jvm;
    ObjectAnimator jvn;
    ObjectAnimator jvo;
    ObjectAnimator jvp;

    public w(ViewGroup viewGroup) {
        this.jvk = viewGroup;
        this.jvl = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.jvm = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.jvn = ObjectAnimator.ofFloat(this.jvl, "alpha", 1.0f, 0.5f);
        this.jvo = ObjectAnimator.ofFloat(this.jvl, "alpha", 0.5f, 0.0f);
        this.jvp = ObjectAnimator.ofFloat(this.jvm, "alpha", 1.0f, 0.0f);
        this.jvn.setDuration(50L);
        this.jvo.setDuration(50L);
        this.jvp.setDuration(50L);
    }

    public void startLoading() {
        cancelAnimator();
        this.jvl.setAlpha(1.0f);
        this.jvm.setAlpha(1.0f);
        this.jvk.setVisibility(0);
        this.jvm.startLoading();
        this.jvn.start();
    }

    public void cxP() {
        cancelAnimator();
        this.jvm.cxP();
    }

    public void cxQ() {
        cancelAnimator();
        this.jvo.start();
        this.jvp.start();
    }

    public void cxR() {
        cancelAnimator();
        this.jvk.setVisibility(8);
        this.jvm.cxR();
    }

    private void cancelAnimator() {
        this.jvn.cancel();
        this.jvo.cancel();
        this.jvp.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.jvm != null) {
            this.jvm.setLoadingAnimationListener(aVar);
        }
    }
}
