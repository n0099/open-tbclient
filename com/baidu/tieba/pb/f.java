package com.baidu.tieba.pb;

import android.view.animation.Animation;
import com.baidu.tieba.view.NavigationBar;
/* loaded from: classes.dex */
class f implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f2176a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f2176a = eVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        NavigationBar navigationBar;
        this.f2176a.f2156a.r = true;
        z = this.f2176a.f2156a.s;
        if (z) {
            this.f2176a.f2156a.s = false;
            navigationBar = this.f2176a.f2156a.l;
            navigationBar.setVisibility(8);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
