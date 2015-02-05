package com.baidu.tieba.image;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class i implements Animation.AnimationListener {
    final /* synthetic */ h bsc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.bsc = hVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ImageViewerActivity imageViewerActivity;
        ImageViewerActivity imageViewerActivity2;
        boolean z;
        ImageViewerActivity imageViewerActivity3;
        ImageViewerActivity imageViewerActivity4;
        NavigationBar navigationBar;
        imageViewerActivity = this.bsc.this$0;
        imageViewerActivity.aRa = true;
        imageViewerActivity2 = this.bsc.this$0;
        z = imageViewerActivity2.aRb;
        if (z) {
            imageViewerActivity3 = this.bsc.this$0;
            imageViewerActivity3.aRb = false;
            imageViewerActivity4 = this.bsc.this$0;
            navigationBar = imageViewerActivity4.aJk;
            navigationBar.setVisibility(8);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
