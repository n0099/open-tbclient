package com.baidu.tieba;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class z implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f2680a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(LogoActivity logoActivity) {
        this.f2680a = logoActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        this.f2680a.b = true;
        z = this.f2680a.c;
        if (z) {
            this.f2680a.a(this.f2680a.getBaseContext());
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
