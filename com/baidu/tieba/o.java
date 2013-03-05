package com.baidu.tieba;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class o implements Animation.AnimationListener {
    final /* synthetic */ LogoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(LogoActivity logoActivity) {
        this.a = logoActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        this.a.d = true;
        z = this.a.e;
        if (!z) {
            return;
        }
        this.a.j();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
