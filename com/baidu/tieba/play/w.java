package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class w {
    private ViewGroup got;
    private ImageView gou;
    private VideoLoadingProgressView gov;
    ObjectAnimator gow;
    ObjectAnimator gox;
    ObjectAnimator goy;

    public w(ViewGroup viewGroup) {
        this.got = viewGroup;
        this.gou = (ImageView) viewGroup.findViewById(e.g.auto_video_loading_image);
        this.gov = (VideoLoadingProgressView) viewGroup.findViewById(e.g.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.gow = ObjectAnimator.ofFloat(this.gou, "alpha", 1.0f, 0.5f);
        this.gox = ObjectAnimator.ofFloat(this.gou, "alpha", 0.5f, 0.0f);
        this.goy = ObjectAnimator.ofFloat(this.gov, "alpha", 1.0f, 0.0f);
        this.gow.setDuration(50L);
        this.gox.setDuration(50L);
        this.goy.setDuration(50L);
    }

    public void startLoading() {
        bnw();
        this.gou.setAlpha(1.0f);
        this.gov.setAlpha(1.0f);
        this.got.setVisibility(0);
        this.gov.startLoading();
        this.gow.start();
    }

    public void bnt() {
        bnw();
        this.gov.bnt();
    }

    public void bnu() {
        bnw();
        this.gox.start();
        this.goy.start();
    }

    public void bnv() {
        bnw();
        this.got.setVisibility(8);
        this.gov.bnv();
    }

    private void bnw() {
        this.gow.cancel();
        this.gox.cancel();
        this.goy.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.gov != null) {
            this.gov.setLoadingAnimationListener(aVar);
        }
    }
}
