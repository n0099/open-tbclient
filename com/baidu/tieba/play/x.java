package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class x {
    private ViewGroup iqI;
    private ImageView iqJ;
    private VideoLoadingProgressView iqK;
    ObjectAnimator iqL;
    ObjectAnimator iqM;
    ObjectAnimator iqN;

    public x(ViewGroup viewGroup) {
        this.iqI = viewGroup;
        this.iqJ = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.iqK = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.iqL = ObjectAnimator.ofFloat(this.iqJ, "alpha", 1.0f, 0.5f);
        this.iqM = ObjectAnimator.ofFloat(this.iqJ, "alpha", 0.5f, 0.0f);
        this.iqN = ObjectAnimator.ofFloat(this.iqK, "alpha", 1.0f, 0.0f);
        this.iqL.setDuration(50L);
        this.iqM.setDuration(50L);
        this.iqN.setDuration(50L);
    }

    public void startLoading() {
        cbT();
        this.iqJ.setAlpha(1.0f);
        this.iqK.setAlpha(1.0f);
        this.iqI.setVisibility(0);
        this.iqK.startLoading();
        this.iqL.start();
    }

    public void cbQ() {
        cbT();
        this.iqK.cbQ();
    }

    public void cbR() {
        cbT();
        this.iqM.start();
        this.iqN.start();
    }

    public void cbS() {
        cbT();
        this.iqI.setVisibility(8);
        this.iqK.cbS();
    }

    private void cbT() {
        this.iqL.cancel();
        this.iqM.cancel();
        this.iqN.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.iqK != null) {
            this.iqK.setLoadingAnimationListener(aVar);
        }
    }
}
