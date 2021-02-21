package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class m {
    private ViewGroup mHT;
    private ImageView mHU;
    private VideoLoadingProgressView mHV;
    ObjectAnimator mHW;
    ObjectAnimator mHX;
    ObjectAnimator mHY;

    public m(ViewGroup viewGroup) {
        this.mHT = viewGroup;
        this.mHU = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.mHV = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.mHW = ObjectAnimator.ofFloat(this.mHU, "alpha", 1.0f, 0.5f);
        this.mHX = ObjectAnimator.ofFloat(this.mHU, "alpha", 0.5f, 0.0f);
        this.mHY = ObjectAnimator.ofFloat(this.mHV, "alpha", 1.0f, 0.0f);
        this.mHW.setDuration(50L);
        this.mHX.setDuration(50L);
        this.mHY.setDuration(50L);
    }

    public void startLoading() {
        dAk();
        this.mHU.setAlpha(1.0f);
        this.mHV.setAlpha(1.0f);
        this.mHT.setVisibility(0);
        this.mHV.startLoading();
        this.mHW.start();
    }

    public void dAh() {
        dAk();
        this.mHV.dAh();
    }

    public void dAi() {
        dAk();
        this.mHX.start();
        this.mHY.start();
    }

    public void dAj() {
        dAk();
        this.mHT.setVisibility(8);
        this.mHV.dAj();
    }

    private void dAk() {
        this.mHW.cancel();
        this.mHX.cancel();
        this.mHY.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.mHV != null) {
            this.mHV.setLoadingAnimationListener(aVar);
        }
    }
}
