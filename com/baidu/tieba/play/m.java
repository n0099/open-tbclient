package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class m {
    private VideoLoadingProgressView myA;
    ObjectAnimator myB;
    ObjectAnimator myC;
    ObjectAnimator myD;
    private ViewGroup myy;
    private ImageView myz;

    public m(ViewGroup viewGroup) {
        this.myy = viewGroup;
        this.myz = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.myA = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.myB = ObjectAnimator.ofFloat(this.myz, "alpha", 1.0f, 0.5f);
        this.myC = ObjectAnimator.ofFloat(this.myz, "alpha", 0.5f, 0.0f);
        this.myD = ObjectAnimator.ofFloat(this.myA, "alpha", 1.0f, 0.0f);
        this.myB.setDuration(50L);
        this.myC.setDuration(50L);
        this.myD.setDuration(50L);
    }

    public void startLoading() {
        dxV();
        this.myz.setAlpha(1.0f);
        this.myA.setAlpha(1.0f);
        this.myy.setVisibility(0);
        this.myA.startLoading();
        this.myB.start();
    }

    public void dxS() {
        dxV();
        this.myA.dxS();
    }

    public void dxT() {
        dxV();
        this.myC.start();
        this.myD.start();
    }

    public void dxU() {
        dxV();
        this.myy.setVisibility(8);
        this.myA.dxU();
    }

    private void dxV() {
        this.myB.cancel();
        this.myC.cancel();
        this.myD.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.myA != null) {
            this.myA.setLoadingAnimationListener(aVar);
        }
    }
}
