package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes2.dex */
public class m {
    private ViewGroup lsD;
    private ImageView lsE;
    private VideoLoadingProgressView lsF;
    ObjectAnimator lsG;
    ObjectAnimator lsH;
    ObjectAnimator lsI;

    public m(ViewGroup viewGroup) {
        this.lsD = viewGroup;
        this.lsE = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.lsF = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.lsG = ObjectAnimator.ofFloat(this.lsE, "alpha", 1.0f, 0.5f);
        this.lsH = ObjectAnimator.ofFloat(this.lsE, "alpha", 0.5f, 0.0f);
        this.lsI = ObjectAnimator.ofFloat(this.lsF, "alpha", 1.0f, 0.0f);
        this.lsG.setDuration(50L);
        this.lsH.setDuration(50L);
        this.lsI.setDuration(50L);
    }

    public void startLoading() {
        cancelAnimator();
        this.lsE.setAlpha(1.0f);
        this.lsF.setAlpha(1.0f);
        this.lsD.setVisibility(0);
        this.lsF.startLoading();
        this.lsG.start();
    }

    public void djY() {
        cancelAnimator();
        this.lsF.djY();
    }

    public void djZ() {
        cancelAnimator();
        this.lsH.start();
        this.lsI.start();
    }

    public void dka() {
        cancelAnimator();
        this.lsD.setVisibility(8);
        this.lsF.dka();
    }

    private void cancelAnimator() {
        this.lsG.cancel();
        this.lsH.cancel();
        this.lsI.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.lsF != null) {
            this.lsF.setLoadingAnimationListener(aVar);
        }
    }
}
