package com.baidu.tieba.image;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class i implements Animation.AnimationListener {
    final /* synthetic */ h bsd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.bsd = hVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ImageViewerActivity imageViewerActivity;
        ImageViewerActivity imageViewerActivity2;
        boolean z;
        ImageViewerActivity imageViewerActivity3;
        ImageViewerActivity imageViewerActivity4;
        NavigationBar navigationBar;
        imageViewerActivity = this.bsd.this$0;
        imageViewerActivity.aRb = true;
        imageViewerActivity2 = this.bsd.this$0;
        z = imageViewerActivity2.aRc;
        if (z) {
            imageViewerActivity3 = this.bsd.this$0;
            imageViewerActivity3.aRc = false;
            imageViewerActivity4 = this.bsd.this$0;
            navigationBar = imageViewerActivity4.aJn;
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
