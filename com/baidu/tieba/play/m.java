package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class m {
    private ViewGroup mKa;
    private ImageView mKb;
    private VideoLoadingProgressView mKc;
    ObjectAnimator mKd;
    ObjectAnimator mKe;
    ObjectAnimator mKf;

    public m(ViewGroup viewGroup) {
        this.mKa = viewGroup;
        this.mKb = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.mKc = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.mKd = ObjectAnimator.ofFloat(this.mKb, "alpha", 1.0f, 0.5f);
        this.mKe = ObjectAnimator.ofFloat(this.mKb, "alpha", 0.5f, 0.0f);
        this.mKf = ObjectAnimator.ofFloat(this.mKc, "alpha", 1.0f, 0.0f);
        this.mKd.setDuration(50L);
        this.mKe.setDuration(50L);
        this.mKf.setDuration(50L);
    }

    public void startLoading() {
        dAs();
        this.mKb.setAlpha(1.0f);
        this.mKc.setAlpha(1.0f);
        this.mKa.setVisibility(0);
        this.mKc.startLoading();
        this.mKd.start();
    }

    public void dAp() {
        dAs();
        this.mKc.dAp();
    }

    public void dAq() {
        dAs();
        this.mKe.start();
        this.mKf.start();
    }

    public void dAr() {
        dAs();
        this.mKa.setVisibility(8);
        this.mKc.dAr();
    }

    private void dAs() {
        this.mKd.cancel();
        this.mKe.cancel();
        this.mKf.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.mKc != null) {
            this.mKc.setLoadingAnimationListener(aVar);
        }
    }
}
