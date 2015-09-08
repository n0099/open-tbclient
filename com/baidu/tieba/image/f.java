package com.baidu.tieba.image;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class f implements Animation.AnimationListener {
    final /* synthetic */ e bMj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.bMj = eVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ImageViewerActivity imageViewerActivity;
        ImageViewerActivity imageViewerActivity2;
        boolean z;
        ImageViewerActivity imageViewerActivity3;
        ImageViewerActivity imageViewerActivity4;
        NavigationBar navigationBar;
        imageViewerActivity = this.bMj.this$0;
        imageViewerActivity.bnw = true;
        imageViewerActivity2 = this.bMj.this$0;
        z = imageViewerActivity2.bnx;
        if (z) {
            imageViewerActivity3 = this.bMj.this$0;
            imageViewerActivity3.bnx = false;
            imageViewerActivity4 = this.bMj.this$0;
            navigationBar = imageViewerActivity4.bdE;
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
