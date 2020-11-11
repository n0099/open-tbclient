package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class m {
    private ViewGroup mjs;
    private ImageView mjt;
    private VideoLoadingProgressView mju;
    ObjectAnimator mjv;
    ObjectAnimator mjw;
    ObjectAnimator mjx;

    public m(ViewGroup viewGroup) {
        this.mjs = viewGroup;
        this.mjt = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.mju = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.mjv = ObjectAnimator.ofFloat(this.mjt, "alpha", 1.0f, 0.5f);
        this.mjw = ObjectAnimator.ofFloat(this.mjt, "alpha", 0.5f, 0.0f);
        this.mjx = ObjectAnimator.ofFloat(this.mju, "alpha", 1.0f, 0.0f);
        this.mjv.setDuration(50L);
        this.mjw.setDuration(50L);
        this.mjx.setDuration(50L);
    }

    public void startLoading() {
        dxe();
        this.mjt.setAlpha(1.0f);
        this.mju.setAlpha(1.0f);
        this.mjs.setVisibility(0);
        this.mju.startLoading();
        this.mjv.start();
    }

    public void dxb() {
        dxe();
        this.mju.dxb();
    }

    public void dxc() {
        dxe();
        this.mjw.start();
        this.mjx.start();
    }

    public void dxd() {
        dxe();
        this.mjs.setVisibility(8);
        this.mju.dxd();
    }

    private void dxe() {
        this.mjv.cancel();
        this.mjw.cancel();
        this.mjx.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.mju != null) {
            this.mju.setLoadingAnimationListener(aVar);
        }
    }
}
