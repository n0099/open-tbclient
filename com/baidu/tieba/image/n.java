package com.baidu.tieba.image;

import android.view.animation.Animation;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Animation.AnimationListener {
    final /* synthetic */ ImageViewerActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ImageViewerActivity imageViewerActivity) {
        this.this$0 = imageViewerActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        NavigationBar navigationBar;
        this.this$0.bNG = true;
        z = this.this$0.bNH;
        if (z) {
            this.this$0.bNH = false;
            navigationBar = this.this$0.bse;
            navigationBar.setVisibility(8);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.this$0.coR.setSystemUiVisibility(4);
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
