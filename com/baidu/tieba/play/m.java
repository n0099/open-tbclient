package com.baidu.tieba.play;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
/* loaded from: classes.dex */
public class m {
    private ViewGroup lci;
    private ImageView lcj;
    private VideoLoadingProgressView lck;
    ObjectAnimator lcl;
    ObjectAnimator lcm;
    ObjectAnimator lcn;

    public m(ViewGroup viewGroup) {
        this.lci = viewGroup;
        this.lcj = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.lck = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        init();
    }

    private void init() {
        this.lcl = ObjectAnimator.ofFloat(this.lcj, "alpha", 1.0f, 0.5f);
        this.lcm = ObjectAnimator.ofFloat(this.lcj, "alpha", 0.5f, 0.0f);
        this.lcn = ObjectAnimator.ofFloat(this.lck, "alpha", 1.0f, 0.0f);
        this.lcl.setDuration(50L);
        this.lcm.setDuration(50L);
        this.lcn.setDuration(50L);
    }

    public void startLoading() {
        cancelAnimator();
        this.lcj.setAlpha(1.0f);
        this.lck.setAlpha(1.0f);
        this.lci.setVisibility(0);
        this.lck.startLoading();
        this.lcl.start();
    }

    public void cYV() {
        cancelAnimator();
        this.lck.cYV();
    }

    public void cYW() {
        cancelAnimator();
        this.lcm.start();
        this.lcn.start();
    }

    public void cYX() {
        cancelAnimator();
        this.lci.setVisibility(8);
        this.lck.cYX();
    }

    private void cancelAnimator() {
        this.lcl.cancel();
        this.lcm.cancel();
        this.lcn.cancel();
    }

    public void setLoadingAnimationListener(VideoLoadingProgressView.a aVar) {
        if (this.lck != null) {
            this.lck.setLoadingAnimationListener(aVar);
        }
    }
}
