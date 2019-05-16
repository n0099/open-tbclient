package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class x {
    private ViewGroup iqE;
    private ImageView iqF;
    private VideoLoadingProgressView iqG;
    ObjectAnimator iqH;
    ObjectAnimator iqI;
    ObjectAnimator iqJ;

    public x(ViewGroup viewGroup) {
        this.iqE = viewGroup;
        this.iqF = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.iqG = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.iqH = ObjectAnimator.ofFloat(this.iqF, "alpha", 1.0f, 0.5f);
        this.iqI = ObjectAnimator.ofFloat(this.iqF, "alpha", 0.5f, 0.0f);
        this.iqJ = ObjectAnimator.ofFloat(this.iqG, "alpha", 1.0f, 0.0f);
        this.iqH.setDuration(50L);
        this.iqI.setDuration(50L);
        this.iqJ.setDuration(50L);
    }

    public void startLoading() {
        cbP();
        this.iqF.setAlpha(1.0f);
        this.iqG.setAlpha(1.0f);
        this.iqE.setVisibility(0);
        this.iqG.startLoading();
        this.iqH.start();
    }

    public void cbM() {
        cbP();
        this.iqG.cbM();
    }

    public void cbN() {
        cbP();
        this.iqI.start();
        this.iqJ.start();
    }

    public void cbO() {
        cbP();
        this.iqE.setVisibility(8);
        this.iqG.cbO();
    }

    private void cbP() {
        this.iqH.cancel();
        this.iqI.cancel();
        this.iqJ.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.iqG != null) {
            this.iqG.setLoadingAnimationListener(aVar);
        }
    }
}
