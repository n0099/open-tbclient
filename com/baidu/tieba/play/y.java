package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class y {
    private ViewGroup gvj;
    private ImageView gvk;
    private VideoLoadingProgressView gvl;
    ObjectAnimator gvm;
    ObjectAnimator gvn;
    ObjectAnimator gvo;

    public y(ViewGroup viewGroup) {
        this.gvj = viewGroup;
        this.gvk = (ImageView) viewGroup.findViewById(d.g.auto_video_loading_image);
        this.gvl = (VideoLoadingProgressView) viewGroup.findViewById(d.g.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.gvm = ObjectAnimator.ofFloat(this.gvk, "alpha", 1.0f, 0.5f);
        this.gvn = ObjectAnimator.ofFloat(this.gvk, "alpha", 0.5f, 0.0f);
        this.gvo = ObjectAnimator.ofFloat(this.gvl, "alpha", 1.0f, 0.0f);
        this.gvm.setDuration(300L);
        this.gvn.setDuration(300L);
        this.gvo.setDuration(300L);
    }

    public void startLoading() {
        blR();
        this.gvk.setAlpha(1.0f);
        this.gvl.setAlpha(1.0f);
        this.gvj.setVisibility(0);
        this.gvl.startLoading();
        this.gvm.start();
    }

    public void blO() {
        blR();
        this.gvl.blO();
    }

    public void blP() {
        blR();
        this.gvn.start();
        this.gvo.start();
    }

    public void blQ() {
        blR();
        this.gvj.setVisibility(8);
        this.gvl.blQ();
    }

    private void blR() {
        this.gvm.cancel();
        this.gvn.cancel();
        this.gvo.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.gvl != null) {
            this.gvl.setLoadingAnimationListener(aVar);
        }
    }
}
