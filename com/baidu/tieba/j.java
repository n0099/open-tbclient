package com.baidu.tieba;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class j implements Animation.AnimationListener {
    final /* synthetic */ LogoActivity atK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(LogoActivity logoActivity) {
        this.atK = logoActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        this.atK.atB = true;
        z = this.atK.atC;
        if (!z) {
            return;
        }
        this.atK.al(this.atK.getBaseContext());
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
