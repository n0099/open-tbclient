package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class x {
    private ViewGroup iAd;
    private ImageView iAe;
    private VideoLoadingProgressView iAf;
    ObjectAnimator iAg;
    ObjectAnimator iAh;
    ObjectAnimator iAi;

    public x(ViewGroup viewGroup) {
        this.iAd = viewGroup;
        this.iAe = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.iAf = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.iAg = ObjectAnimator.ofFloat(this.iAe, "alpha", 1.0f, 0.5f);
        this.iAh = ObjectAnimator.ofFloat(this.iAe, "alpha", 0.5f, 0.0f);
        this.iAi = ObjectAnimator.ofFloat(this.iAf, "alpha", 1.0f, 0.0f);
        this.iAg.setDuration(50L);
        this.iAh.setDuration(50L);
        this.iAi.setDuration(50L);
    }

    public void startLoading() {
        cfP();
        this.iAe.setAlpha(1.0f);
        this.iAf.setAlpha(1.0f);
        this.iAd.setVisibility(0);
        this.iAf.startLoading();
        this.iAg.start();
    }

    public void cfM() {
        cfP();
        this.iAf.cfM();
    }

    public void cfN() {
        cfP();
        this.iAh.start();
        this.iAi.start();
    }

    public void cfO() {
        cfP();
        this.iAd.setVisibility(8);
        this.iAf.cfO();
    }

    private void cfP() {
        this.iAg.cancel();
        this.iAh.cancel();
        this.iAi.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.iAf != null) {
            this.iAf.setLoadingAnimationListener(aVar);
        }
    }
}
