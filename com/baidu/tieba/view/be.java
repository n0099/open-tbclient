package com.baidu.tieba.view;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class be implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ShutDownValidateTipView f2558a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(ShutDownValidateTipView shutDownValidateTipView) {
        this.f2558a = shutDownValidateTipView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f2558a.setVisibility(8);
    }
}
