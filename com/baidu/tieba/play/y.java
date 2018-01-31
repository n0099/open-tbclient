package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class y {
    private ViewGroup gtO;
    private ImageView gtP;
    private VideoLoadingProgressView gtQ;
    ObjectAnimator gtR;
    ObjectAnimator gtS;
    ObjectAnimator gtT;

    public y(ViewGroup viewGroup) {
        this.gtO = viewGroup;
        this.gtP = (ImageView) viewGroup.findViewById(d.g.auto_video_loading_image);
        this.gtQ = (VideoLoadingProgressView) viewGroup.findViewById(d.g.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.gtR = ObjectAnimator.ofFloat(this.gtP, "alpha", 1.0f, 0.5f);
        this.gtS = ObjectAnimator.ofFloat(this.gtP, "alpha", 0.5f, 0.0f);
        this.gtT = ObjectAnimator.ofFloat(this.gtQ, "alpha", 1.0f, 0.0f);
        this.gtR.setDuration(300L);
        this.gtS.setDuration(300L);
        this.gtT.setDuration(300L);
    }

    public void startLoading() {
        bkF();
        this.gtP.setAlpha(1.0f);
        this.gtQ.setAlpha(1.0f);
        this.gtO.setVisibility(0);
        this.gtQ.startLoading();
        this.gtR.start();
    }

    public void bkC() {
        bkF();
        this.gtQ.bkC();
    }

    public void bkD() {
        bkF();
        this.gtS.start();
        this.gtT.start();
    }

    public void bkE() {
        bkF();
        this.gtO.setVisibility(8);
        this.gtQ.bkE();
    }

    private void bkF() {
        this.gtR.cancel();
        this.gtS.cancel();
        this.gtT.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.gtQ != null) {
            this.gtQ.setLoadingAnimationListener(aVar);
        }
    }
}
