package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class m {
    private ViewGroup lck;
    private ImageView lcl;
    private VideoLoadingProgressView lcm;
    ObjectAnimator lcn;
    ObjectAnimator lco;
    ObjectAnimator lcp;

    public m(ViewGroup viewGroup) {
        this.lck = viewGroup;
        this.lcl = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.lcm = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.lcn = ObjectAnimator.ofFloat(this.lcl, "alpha", 1.0f, 0.5f);
        this.lco = ObjectAnimator.ofFloat(this.lcl, "alpha", 0.5f, 0.0f);
        this.lcp = ObjectAnimator.ofFloat(this.lcm, "alpha", 1.0f, 0.0f);
        this.lcn.setDuration(50L);
        this.lco.setDuration(50L);
        this.lcp.setDuration(50L);
    }

    public void startLoading() {
        cancelAnimator();
        this.lcl.setAlpha(1.0f);
        this.lcm.setAlpha(1.0f);
        this.lck.setVisibility(0);
        this.lcm.startLoading();
        this.lcn.start();
    }

    public void cYV() {
        cancelAnimator();
        this.lcm.cYV();
    }

    public void cYW() {
        cancelAnimator();
        this.lco.start();
        this.lcp.start();
    }

    public void cYX() {
        cancelAnimator();
        this.lck.setVisibility(8);
        this.lcm.cYX();
    }

    private void cancelAnimator() {
        this.lcn.cancel();
        this.lco.cancel();
        this.lcp.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.lcm != null) {
            this.lcm.setLoadingAnimationListener(aVar);
        }
    }
}
