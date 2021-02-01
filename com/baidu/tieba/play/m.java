package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class m {
    private ViewGroup mHE;
    private ImageView mHF;
    private VideoLoadingProgressView mHG;
    ObjectAnimator mHH;
    ObjectAnimator mHI;
    ObjectAnimator mHJ;

    public m(ViewGroup viewGroup) {
        this.mHE = viewGroup;
        this.mHF = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.mHG = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.mHH = ObjectAnimator.ofFloat(this.mHF, "alpha", 1.0f, 0.5f);
        this.mHI = ObjectAnimator.ofFloat(this.mHF, "alpha", 0.5f, 0.0f);
        this.mHJ = ObjectAnimator.ofFloat(this.mHG, "alpha", 1.0f, 0.0f);
        this.mHH.setDuration(50L);
        this.mHI.setDuration(50L);
        this.mHJ.setDuration(50L);
    }

    public void startLoading() {
        dAd();
        this.mHF.setAlpha(1.0f);
        this.mHG.setAlpha(1.0f);
        this.mHE.setVisibility(0);
        this.mHG.startLoading();
        this.mHH.start();
    }

    public void dAa() {
        dAd();
        this.mHG.dAa();
    }

    public void dAb() {
        dAd();
        this.mHI.start();
        this.mHJ.start();
    }

    public void dAc() {
        dAd();
        this.mHE.setVisibility(8);
        this.mHG.dAc();
    }

    private void dAd() {
        this.mHH.cancel();
        this.mHI.cancel();
        this.mHJ.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.mHG != null) {
            this.mHG.setLoadingAnimationListener(aVar);
        }
    }
}
