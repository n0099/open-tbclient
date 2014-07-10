package com.baidu.tieba.image;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class g implements Animation.AnimationListener {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.a = fVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ImageViewerActivity imageViewerActivity;
        ImageViewerActivity imageViewerActivity2;
        boolean z;
        ImageViewerActivity imageViewerActivity3;
        ImageViewerActivity imageViewerActivity4;
        NavigationBar navigationBar;
        imageViewerActivity = this.a.a;
        imageViewerActivity.r = true;
        imageViewerActivity2 = this.a.a;
        z = imageViewerActivity2.s;
        if (z) {
            imageViewerActivity3 = this.a.a;
            imageViewerActivity3.s = false;
            imageViewerActivity4 = this.a.a;
            navigationBar = imageViewerActivity4.l;
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
