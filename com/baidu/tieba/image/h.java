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
        z = this.this$0.aRb;
        if (z) {
            navigationBar = this.this$0.aJn;
            if (navigationBar.getVisibility() != 0) {
                navigationBar3 = this.this$0.aJn;
                navigationBar3.setVisibility(0);
                multiImageView2 = this.this$0.brP;
                multiImageView2.tS();
                this.this$0.akZ = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.this$0.akZ = new AlphaAnimation(1.0f, 0.0f);
                this.this$0.aRc = true;
                multiImageView = this.this$0.brP;
                multiImageView.tT();
            }
            alphaAnimation = this.this$0.akZ;
            alphaAnimation.setDuration(300L);
            alphaAnimation2 = this.this$0.akZ;
            alphaAnimation2.setFillAfter(true);
            alphaAnimation3 = this.this$0.akZ;
            alphaAnimation3.setAnimationListener(new i(this));
            this.this$0.aRb = false;
            navigationBar2 = this.this$0.aJn;
            alphaAnimation4 = this.this$0.akZ;
            navigationBar2.startAnimation(alphaAnimation4);
        }
    }
}
