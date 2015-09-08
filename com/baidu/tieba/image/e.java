package com.baidu.tieba.image;

import android.view.View;
import android.view.animation.AlphaAnimation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ ImageViewerActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ImageViewerActivity imageViewerActivity) {
        this.this$0 = imageViewerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        NavigationBar navigationBar;
        AlphaAnimation alphaAnimation;
        AlphaAnimation alphaAnimation2;
        AlphaAnimation alphaAnimation3;
        NavigationBar navigationBar2;
        AlphaAnimation alphaAnimation4;
        NavigationBar navigationBar3;
        z = this.this$0.bnw;
        if (z) {
            navigationBar = this.this$0.bdE;
            if (navigationBar.getVisibility() != 0) {
                navigationBar3 = this.this$0.bdE;
                navigationBar3.setVisibility(0);
                this.this$0.bLV.zq();
                this.this$0.bnv = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.this$0.bnv = new AlphaAnimation(1.0f, 0.0f);
                this.this$0.bnx = true;
                this.this$0.bLV.zr();
            }
            alphaAnimation = this.this$0.bnv;
            alphaAnimation.setDuration(300L);
            alphaAnimation2 = this.this$0.bnv;
            alphaAnimation2.setFillAfter(false);
            alphaAnimation3 = this.this$0.bnv;
            alphaAnimation3.setAnimationListener(new f(this));
            this.this$0.bnw = false;
            navigationBar2 = this.this$0.bdE;
            alphaAnimation4 = this.this$0.bnv;
            navigationBar2.startAnimation(alphaAnimation4);
        }
    }
}
