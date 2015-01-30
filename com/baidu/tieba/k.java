package com.baidu.tieba;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class k implements Animation.AnimationListener {
    final /* synthetic */ LogoActivity alk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LogoActivity logoActivity) {
        this.alk = logoActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        this.alk.akX = true;
        z = this.alk.akY;
        if (!z) {
            return;
        }
        this.alk.ai(this.alk.getBaseContext());
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
