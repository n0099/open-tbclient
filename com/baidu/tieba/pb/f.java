package com.baidu.tieba.pb;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class f implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f1528a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f1528a = eVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ImageActivity imageActivity;
        ImageActivity imageActivity2;
        boolean z;
        ImageActivity imageActivity3;
        ImageActivity imageActivity4;
        LinearLayout linearLayout;
        imageActivity = this.f1528a.f1527a;
        imageActivity.t = true;
        imageActivity2 = this.f1528a.f1527a;
        z = imageActivity2.u;
        if (z) {
            imageActivity3 = this.f1528a.f1527a;
            imageActivity3.u = false;
            imageActivity4 = this.f1528a.f1527a;
            linearLayout = imageActivity4.n;
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
