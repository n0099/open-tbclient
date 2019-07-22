package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class x {
    private ViewGroup iwY;
    private ImageView iwZ;
    private VideoLoadingProgressView ixa;
    ObjectAnimator ixb;
    ObjectAnimator ixc;
    ObjectAnimator ixd;

    public x(ViewGroup viewGroup) {
        this.iwY = viewGroup;
        this.iwZ = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.ixa = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.ixb = ObjectAnimator.ofFloat(this.iwZ, "alpha", 1.0f, 0.5f);
        this.ixc = ObjectAnimator.ofFloat(this.iwZ, "alpha", 0.5f, 0.0f);
        this.ixd = ObjectAnimator.ofFloat(this.ixa, "alpha", 1.0f, 0.0f);
        this.ixb.setDuration(50L);
        this.ixc.setDuration(50L);
        this.ixd.setDuration(50L);
    }

    public void startLoading() {
        ceJ();
        this.iwZ.setAlpha(1.0f);
        this.ixa.setAlpha(1.0f);
        this.iwY.setVisibility(0);
        this.ixa.startLoading();
        this.ixb.start();
    }

    public void ceG() {
        ceJ();
        this.ixa.ceG();
    }

    public void ceH() {
        ceJ();
        this.ixc.start();
        this.ixd.start();
    }

    public void ceI() {
        ceJ();
        this.iwY.setVisibility(8);
        this.ixa.ceI();
    }

    private void ceJ() {
        this.ixb.cancel();
        this.ixc.cancel();
        this.ixd.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.ixa != null) {
            this.ixa.setLoadingAnimationListener(aVar);
        }
    }
}
