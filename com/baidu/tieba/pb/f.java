package com.baidu.tieba.pb;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class f implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f2134a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f2134a = eVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        LinearLayout linearLayout;
        this.f2134a.f2133a.t = true;
        z = this.f2134a.f2133a.u;
        if (z) {
            this.f2134a.f2133a.u = false;
            linearLayout = this.f2134a.f2133a.n;
            linearLayout.setVisibility(8);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
