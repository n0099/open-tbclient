package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class x {
    private ViewGroup ixJ;
    private ImageView ixK;
    private VideoLoadingProgressView ixL;
    ObjectAnimator ixM;
    ObjectAnimator ixN;
    ObjectAnimator ixO;

    public x(ViewGroup viewGroup) {
        this.ixJ = viewGroup;
        this.ixK = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.ixL = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.ixM = ObjectAnimator.ofFloat(this.ixK, "alpha", 1.0f, 0.5f);
        this.ixN = ObjectAnimator.ofFloat(this.ixK, "alpha", 0.5f, 0.0f);
        this.ixO = ObjectAnimator.ofFloat(this.ixL, "alpha", 1.0f, 0.0f);
        this.ixM.setDuration(50L);
        this.ixN.setDuration(50L);
        this.ixO.setDuration(50L);
    }

    public void startLoading() {
        ccO();
        this.ixK.setAlpha(1.0f);
        this.ixL.setAlpha(1.0f);
        this.ixJ.setVisibility(0);
        this.ixL.startLoading();
        this.ixM.start();
    }

    public void ccL() {
        ccO();
        this.ixL.ccL();
    }

    public void ccM() {
        ccO();
        this.ixN.start();
        this.ixO.start();
    }

    public void ccN() {
        ccO();
        this.ixJ.setVisibility(8);
        this.ixL.ccN();
    }

    private void ccO() {
        this.ixM.cancel();
        this.ixN.cancel();
        this.ixO.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.ixL != null) {
            this.ixL.setLoadingAnimationListener(aVar);
        }
    }
}
