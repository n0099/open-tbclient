package com.baidu.tieba.view;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bx implements Animation.AnimationListener {
    final /* synthetic */ NoNetworkView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(NoNetworkView noNetworkView) {
        this.a = noNetworkView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        this.a.setVisibility(8);
    }
}
