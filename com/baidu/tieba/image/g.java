package com.baidu.tieba.image;

import android.view.View;
import android.view.animation.AlphaAnimation;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ ImageViewerActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ImageViewerActivity imageViewerActivity) {
        this.this$0 = imageViewerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        NavigationBar navigationBar;
        MultiImageView multiImageView;
        AlphaAnimation alphaAnimation;
        AlphaAnimation alphaAnimation2;
        AlphaAnimation alphaAnimation3;
        NavigationBar navigationBar2;
        AlphaAnimation alphaAnimation4;
        NavigationBar navigationBar3;
        MultiImageView multiImageView2;
        z = this.this$0.aWg;
        if (z) {
            navigationBar = this.this$0.aPk;
            if (navigationBar.getVisibility() != 0) {
                navigationBar3 = this.this$0.aPk;
                navigationBar3.setVisibility(0);
                multiImageView2 = this.this$0.buA;
                multiImageView2.xg();
                this.this$0.atw = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.this$0.atw = new AlphaAnimation(1.0f, 0.0f);
                this.this$0.aWh = true;
                multiImageView = this.this$0.buA;
                multiImageView.xh();
            }
            alphaAnimation = this.this$0.atw;
            alphaAnimation.setDuration(300L);
            alphaAnimation2 = this.this$0.atw;
            alphaAnimation2.setFillAfter(true);
            alphaAnimation3 = this.this$0.atw;
            alphaAnimation3.setAnimationListener(new h(this));
            this.this$0.aWg = false;
            navigationBar2 = this.this$0.aPk;
            alphaAnimation4 = this.this$0.atw;
            navigationBar2.startAnimation(alphaAnimation4);
        }
    }
}
