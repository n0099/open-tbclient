package com.baidu.tieba.image;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class h implements Animation.AnimationListener {
    final /* synthetic */ g buO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.buO = gVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ImageViewerActivity imageViewerActivity;
        ImageViewerActivity imageViewerActivity2;
        boolean z;
        ImageViewerActivity imageViewerActivity3;
        ImageViewerActivity imageViewerActivity4;
        NavigationBar navigationBar;
        imageViewerActivity = this.buO.this$0;
        imageViewerActivity.aWg = true;
        imageViewerActivity2 = this.buO.this$0;
        z = imageViewerActivity2.aWh;
        if (z) {
            imageViewerActivity3 = this.buO.this$0;
            imageViewerActivity3.aWh = false;
            imageViewerActivity4 = this.buO.this$0;
            navigationBar = imageViewerActivity4.aPk;
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
