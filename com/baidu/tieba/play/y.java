package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class y {
    private ViewGroup gvu;
    private ImageView gvv;
    private VideoLoadingProgressView gvw;
    ObjectAnimator gvx;
    ObjectAnimator gvy;
    ObjectAnimator gvz;

    public y(ViewGroup viewGroup) {
        this.gvu = viewGroup;
        this.gvv = (ImageView) viewGroup.findViewById(d.g.auto_video_loading_image);
        this.gvw = (VideoLoadingProgressView) viewGroup.findViewById(d.g.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.gvx = ObjectAnimator.ofFloat(this.gvv, "alpha", 1.0f, 0.5f);
        this.gvy = ObjectAnimator.ofFloat(this.gvv, "alpha", 0.5f, 0.0f);
        this.gvz = ObjectAnimator.ofFloat(this.gvw, "alpha", 1.0f, 0.0f);
        this.gvx.setDuration(300L);
        this.gvy.setDuration(300L);
        this.gvz.setDuration(300L);
    }

    public void startLoading() {
        blS();
        this.gvv.setAlpha(1.0f);
        this.gvw.setAlpha(1.0f);
        this.gvu.setVisibility(0);
        this.gvw.startLoading();
        this.gvx.start();
    }

    public void blP() {
        blS();
        this.gvw.blP();
    }

    public void blQ() {
        blS();
        this.gvy.start();
        this.gvz.start();
    }

    public void blR() {
        blS();
        this.gvu.setVisibility(8);
        this.gvw.blR();
    }

    private void blS() {
        this.gvx.cancel();
        this.gvy.cancel();
        this.gvz.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.gvw != null) {
            this.gvw.setLoadingAnimationListener(aVar);
        }
    }
}
