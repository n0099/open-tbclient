package com.baidu.tieba.image;

import android.view.View;
import android.view.animation.AlphaAnimation;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ ImageViewerActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ImageViewerActivity imageViewerActivity) {
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
        z = this.this$0.aPW;
        if (z) {
            navigationBar = this.this$0.aId;
            if (navigationBar.getVisibility() != 0) {
                navigationBar3 = this.this$0.aId;
                navigationBar3.setVisibility(0);
                multiImageView2 = this.this$0.bqr;
                multiImageView2.tB();
                this.this$0.akw = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.this$0.akw = new AlphaAnimation(1.0f, 0.0f);
                this.this$0.aPX = true;
                multiImageView = this.this$0.bqr;
                multiImageView.tC();
            }
            alphaAnimation = this.this$0.akw;
            alphaAnimation.setDuration(300L);
            alphaAnimation2 = this.this$0.akw;
            alphaAnimation2.setFillAfter(true);
            alphaAnimation3 = this.this$0.akw;
            alphaAnimation3.setAnimationListener(new i(this));
            this.this$0.aPW = false;
            navigationBar2 = this.this$0.aId;
            alphaAnimation4 = this.this$0.akw;
            navigationBar2.startAnimation(alphaAnimation4);
        }
    }
}
