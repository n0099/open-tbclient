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
        z = this.this$0.aWw;
        if (z) {
            navigationBar = this.this$0.aPB;
            if (navigationBar.getVisibility() != 0) {
                navigationBar3 = this.this$0.aPB;
                navigationBar3.setVisibility(0);
                multiImageView2 = this.this$0.buQ;
                multiImageView2.xm();
                this.this$0.atE = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.this$0.atE = new AlphaAnimation(1.0f, 0.0f);
                this.this$0.aWx = true;
                multiImageView = this.this$0.buQ;
                multiImageView.xn();
            }
            alphaAnimation = this.this$0.atE;
            alphaAnimation.setDuration(300L);
            alphaAnimation2 = this.this$0.atE;
            alphaAnimation2.setFillAfter(true);
            alphaAnimation3 = this.this$0.atE;
            alphaAnimation3.setAnimationListener(new h(this));
            this.this$0.aWw = false;
            navigationBar2 = this.this$0.aPB;
            alphaAnimation4 = this.this$0.atE;
            navigationBar2.startAnimation(alphaAnimation4);
        }
    }
}
