package com.baidu.tieba.view;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class ay implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NoNetworkView f2570a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(NoNetworkView noNetworkView) {
        this.f2570a = noNetworkView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f2570a.setVisibility(8);
    }
}
