package com.baidu.tieba;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class z implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f2136a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(LogoActivity logoActivity) {
        this.f2136a = logoActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        this.f2136a.b = true;
        z = this.f2136a.c;
        if (!z) {
            return;
        }
        this.f2136a.a(this.f2136a.getBaseContext());
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
