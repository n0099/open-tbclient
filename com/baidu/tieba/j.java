package com.baidu.tieba;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class j implements Animation.AnimationListener {
    final /* synthetic */ LogoActivity atC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(LogoActivity logoActivity) {
        this.atC = logoActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        this.atC.att = true;
        z = this.atC.atu;
        if (!z) {
            return;
        }
        this.atC.al(this.atC.getBaseContext());
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
