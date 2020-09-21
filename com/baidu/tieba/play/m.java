package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class m {
    private ViewGroup lBG;
    private ImageView lBH;
    private VideoLoadingProgressView lBI;
    ObjectAnimator lBJ;
    ObjectAnimator lBK;
    ObjectAnimator lBL;

    public m(ViewGroup viewGroup) {
        this.lBG = viewGroup;
        this.lBH = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.lBI = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.lBJ = ObjectAnimator.ofFloat(this.lBH, "alpha", 1.0f, 0.5f);
        this.lBK = ObjectAnimator.ofFloat(this.lBH, "alpha", 0.5f, 0.0f);
        this.lBL = ObjectAnimator.ofFloat(this.lBI, "alpha", 1.0f, 0.0f);
        this.lBJ.setDuration(50L);
        this.lBK.setDuration(50L);
        this.lBL.setDuration(50L);
    }

    public void startLoading() {
        dnK();
        this.lBH.setAlpha(1.0f);
        this.lBI.setAlpha(1.0f);
        this.lBG.setVisibility(0);
        this.lBI.startLoading();
        this.lBJ.start();
    }

    public void dnH() {
        dnK();
        this.lBI.dnH();
    }

    public void dnI() {
        dnK();
        this.lBK.start();
        this.lBL.start();
    }

    public void dnJ() {
        dnK();
        this.lBG.setVisibility(8);
        this.lBI.dnJ();
    }

    private void dnK() {
        this.lBJ.cancel();
        this.lBK.cancel();
        this.lBL.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.lBI != null) {
            this.lBI.setLoadingAnimationListener(aVar);
        }
    }
}
