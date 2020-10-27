package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class m {
    private ViewGroup mdt;
    private ImageView mdu;
    private VideoLoadingProgressView mdv;
    ObjectAnimator mdw;
    ObjectAnimator mdx;
    ObjectAnimator mdy;

    public m(ViewGroup viewGroup) {
        this.mdt = viewGroup;
        this.mdu = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.mdv = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.mdw = ObjectAnimator.ofFloat(this.mdu, "alpha", 1.0f, 0.5f);
        this.mdx = ObjectAnimator.ofFloat(this.mdu, "alpha", 0.5f, 0.0f);
        this.mdy = ObjectAnimator.ofFloat(this.mdv, "alpha", 1.0f, 0.0f);
        this.mdw.setDuration(50L);
        this.mdx.setDuration(50L);
        this.mdy.setDuration(50L);
    }

    public void startLoading() {
        duC();
        this.mdu.setAlpha(1.0f);
        this.mdv.setAlpha(1.0f);
        this.mdt.setVisibility(0);
        this.mdv.startLoading();
        this.mdw.start();
    }

    public void duz() {
        duC();
        this.mdv.duz();
    }

    public void duA() {
        duC();
        this.mdx.start();
        this.mdy.start();
    }

    public void duB() {
        duC();
        this.mdt.setVisibility(8);
        this.mdv.duB();
    }

    private void duC() {
        this.mdw.cancel();
        this.mdx.cancel();
        this.mdy.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.mdv != null) {
            this.mdv.setLoadingAnimationListener(aVar);
        }
    }
}
