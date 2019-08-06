package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class x {
    private ViewGroup iyb;
    private ImageView iyc;
    private VideoLoadingProgressView iyd;
    ObjectAnimator iye;
    ObjectAnimator iyf;
    ObjectAnimator iyg;

    public x(ViewGroup viewGroup) {
        this.iyb = viewGroup;
        this.iyc = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.iyd = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.iye = ObjectAnimator.ofFloat(this.iyc, "alpha", 1.0f, 0.5f);
        this.iyf = ObjectAnimator.ofFloat(this.iyc, "alpha", 0.5f, 0.0f);
        this.iyg = ObjectAnimator.ofFloat(this.iyd, "alpha", 1.0f, 0.0f);
        this.iye.setDuration(50L);
        this.iyf.setDuration(50L);
        this.iyg.setDuration(50L);
    }

    public void startLoading() {
        cfb();
        this.iyc.setAlpha(1.0f);
        this.iyd.setAlpha(1.0f);
        this.iyb.setVisibility(0);
        this.iyd.startLoading();
        this.iye.start();
    }

    public void ceY() {
        cfb();
        this.iyd.ceY();
    }

    public void ceZ() {
        cfb();
        this.iyf.start();
        this.iyg.start();
    }

    public void cfa() {
        cfb();
        this.iyb.setVisibility(8);
        this.iyd.cfa();
    }

    private void cfb() {
        this.iye.cancel();
        this.iyf.cancel();
        this.iyg.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.iyd != null) {
            this.iyd.setLoadingAnimationListener(aVar);
        }
    }
}
