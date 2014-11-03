package com.baidu.tieba;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class k implements Animation.AnimationListener {
    final /* synthetic */ LogoActivity acU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LogoActivity logoActivity) {
        this.acU = logoActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        this.acU.acI = true;
        z = this.acU.acJ;
        if (!z) {
            return;
        }
        this.acU.L(this.acU.getBaseContext());
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
