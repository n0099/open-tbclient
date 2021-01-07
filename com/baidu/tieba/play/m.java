package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class m {
    private ViewGroup mDf;
    private ImageView mDg;
    private VideoLoadingProgressView mDh;
    ObjectAnimator mDi;
    ObjectAnimator mDj;
    ObjectAnimator mDk;

    public m(ViewGroup viewGroup) {
        this.mDf = viewGroup;
        this.mDg = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.mDh = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.mDi = ObjectAnimator.ofFloat(this.mDg, "alpha", 1.0f, 0.5f);
        this.mDj = ObjectAnimator.ofFloat(this.mDg, "alpha", 0.5f, 0.0f);
        this.mDk = ObjectAnimator.ofFloat(this.mDh, "alpha", 1.0f, 0.0f);
        this.mDi.setDuration(50L);
        this.mDj.setDuration(50L);
        this.mDk.setDuration(50L);
    }

    public void startLoading() {
        dBN();
        this.mDg.setAlpha(1.0f);
        this.mDh.setAlpha(1.0f);
        this.mDf.setVisibility(0);
        this.mDh.startLoading();
        this.mDi.start();
    }

    public void dBK() {
        dBN();
        this.mDh.dBK();
    }

    public void dBL() {
        dBN();
        this.mDj.start();
        this.mDk.start();
    }

    public void dBM() {
        dBN();
        this.mDf.setVisibility(8);
        this.mDh.dBM();
    }

    private void dBN() {
        this.mDi.cancel();
        this.mDj.cancel();
        this.mDk.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.mDh != null) {
            this.mDh.setLoadingAnimationListener(aVar);
        }
    }
}
