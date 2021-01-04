package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class m {
    private ViewGroup mDg;
    private ImageView mDh;
    private VideoLoadingProgressView mDi;
    ObjectAnimator mDj;
    ObjectAnimator mDk;
    ObjectAnimator mDl;

    public m(ViewGroup viewGroup) {
        this.mDg = viewGroup;
        this.mDh = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.mDi = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.mDj = ObjectAnimator.ofFloat(this.mDh, "alpha", 1.0f, 0.5f);
        this.mDk = ObjectAnimator.ofFloat(this.mDh, "alpha", 0.5f, 0.0f);
        this.mDl = ObjectAnimator.ofFloat(this.mDi, "alpha", 1.0f, 0.0f);
        this.mDj.setDuration(50L);
        this.mDk.setDuration(50L);
        this.mDl.setDuration(50L);
    }

    public void startLoading() {
        dBM();
        this.mDh.setAlpha(1.0f);
        this.mDi.setAlpha(1.0f);
        this.mDg.setVisibility(0);
        this.mDi.startLoading();
        this.mDj.start();
    }

    public void dBJ() {
        dBM();
        this.mDi.dBJ();
    }

    public void dBK() {
        dBM();
        this.mDk.start();
        this.mDl.start();
    }

    public void dBL() {
        dBM();
        this.mDg.setVisibility(8);
        this.mDi.dBL();
    }

    private void dBM() {
        this.mDj.cancel();
        this.mDk.cancel();
        this.mDl.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.mDi != null) {
            this.mDi.setLoadingAnimationListener(aVar);
        }
    }
}
