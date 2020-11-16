package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class m {
    private ViewGroup mjL;
    private ImageView mjM;
    private VideoLoadingProgressView mjN;
    ObjectAnimator mjO;
    ObjectAnimator mjP;
    ObjectAnimator mjQ;

    public m(ViewGroup viewGroup) {
        this.mjL = viewGroup;
        this.mjM = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.mjN = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.mjO = ObjectAnimator.ofFloat(this.mjM, "alpha", 1.0f, 0.5f);
        this.mjP = ObjectAnimator.ofFloat(this.mjM, "alpha", 0.5f, 0.0f);
        this.mjQ = ObjectAnimator.ofFloat(this.mjN, "alpha", 1.0f, 0.0f);
        this.mjO.setDuration(50L);
        this.mjP.setDuration(50L);
        this.mjQ.setDuration(50L);
    }

    public void startLoading() {
        dwE();
        this.mjM.setAlpha(1.0f);
        this.mjN.setAlpha(1.0f);
        this.mjL.setVisibility(0);
        this.mjN.startLoading();
        this.mjO.start();
    }

    public void dwB() {
        dwE();
        this.mjN.dwB();
    }

    public void dwC() {
        dwE();
        this.mjP.start();
        this.mjQ.start();
    }

    public void dwD() {
        dwE();
        this.mjL.setVisibility(8);
        this.mjN.dwD();
    }

    private void dwE() {
        this.mjO.cancel();
        this.mjP.cancel();
        this.mjQ.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.mjN != null) {
            this.mjN.setLoadingAnimationListener(aVar);
        }
    }
}
