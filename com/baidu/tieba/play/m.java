package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class m {
    private ViewGroup lsO;
    private ImageView lsP;
    private VideoLoadingProgressView lsQ;
    ObjectAnimator lsR;
    ObjectAnimator lsS;
    ObjectAnimator lsT;

    public m(ViewGroup viewGroup) {
        this.lsO = viewGroup;
        this.lsP = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.lsQ = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.lsR = ObjectAnimator.ofFloat(this.lsP, "alpha", 1.0f, 0.5f);
        this.lsS = ObjectAnimator.ofFloat(this.lsP, "alpha", 0.5f, 0.0f);
        this.lsT = ObjectAnimator.ofFloat(this.lsQ, "alpha", 1.0f, 0.0f);
        this.lsR.setDuration(50L);
        this.lsS.setDuration(50L);
        this.lsT.setDuration(50L);
    }

    public void startLoading() {
        cancelAnimator();
        this.lsP.setAlpha(1.0f);
        this.lsQ.setAlpha(1.0f);
        this.lsO.setVisibility(0);
        this.lsQ.startLoading();
        this.lsR.start();
    }

    public void dkb() {
        cancelAnimator();
        this.lsQ.dkb();
    }

    public void dkc() {
        cancelAnimator();
        this.lsS.start();
        this.lsT.start();
    }

    public void dkd() {
        cancelAnimator();
        this.lsO.setVisibility(8);
        this.lsQ.dkd();
    }

    private void cancelAnimator() {
        this.lsR.cancel();
        this.lsS.cancel();
        this.lsT.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.lsQ != null) {
            this.lsQ.setLoadingAnimationListener(aVar);
        }
    }
}
