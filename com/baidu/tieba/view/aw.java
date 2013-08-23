package com.baidu.tieba.view;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class aw implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NoNetworkView f1856a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(NoNetworkView noNetworkView) {
        this.f1856a = noNetworkView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f1856a.setVisibility(8);
    }
}
