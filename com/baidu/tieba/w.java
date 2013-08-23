package com.baidu.tieba;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class w implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f1884a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(LogoActivity logoActivity) {
        this.f1884a = logoActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        this.f1884a.b = true;
        z = this.f1884a.c;
        if (!z) {
            return;
        }
        this.f1884a.a(this.f1884a.getBaseContext());
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
