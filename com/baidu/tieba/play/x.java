package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class x {
    private ViewGroup iqH;
    private ImageView iqI;
    private VideoLoadingProgressView iqJ;
    ObjectAnimator iqK;
    ObjectAnimator iqL;
    ObjectAnimator iqM;

    public x(ViewGroup viewGroup) {
        this.iqH = viewGroup;
        this.iqI = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.iqJ = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.iqK = ObjectAnimator.ofFloat(this.iqI, "alpha", 1.0f, 0.5f);
        this.iqL = ObjectAnimator.ofFloat(this.iqI, "alpha", 0.5f, 0.0f);
        this.iqM = ObjectAnimator.ofFloat(this.iqJ, "alpha", 1.0f, 0.0f);
        this.iqK.setDuration(50L);
        this.iqL.setDuration(50L);
        this.iqM.setDuration(50L);
    }

    public void startLoading() {
        cbS();
        this.iqI.setAlpha(1.0f);
        this.iqJ.setAlpha(1.0f);
        this.iqH.setVisibility(0);
        this.iqJ.startLoading();
        this.iqK.start();
    }

    public void cbP() {
        cbS();
        this.iqJ.cbP();
    }

    public void cbQ() {
        cbS();
        this.iqL.start();
        this.iqM.start();
    }

    public void cbR() {
        cbS();
        this.iqH.setVisibility(8);
        this.iqJ.cbR();
    }

    private void cbS() {
        this.iqK.cancel();
        this.iqL.cancel();
        this.iqM.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.iqJ != null) {
            this.iqJ.setLoadingAnimationListener(aVar);
        }
    }
}
