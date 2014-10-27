package com.baidu.tieba;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class k implements Animation.AnimationListener {
    final /* synthetic */ LogoActivity acP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LogoActivity logoActivity) {
        this.acP = logoActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        this.acP.acD = true;
        z = this.acP.acE;
        if (!z) {
            return;
        }
        this.acP.L(this.acP.getBaseContext());
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
