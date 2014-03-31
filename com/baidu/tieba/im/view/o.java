package com.baidu.tieba.im.view;

import android.view.animation.Animation;
/* loaded from: classes.dex */
final class o implements Animation.AnimationListener {
    final /* synthetic */ ShutDownValidateTipView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ShutDownValidateTipView shutDownValidateTipView) {
        this.a = shutDownValidateTipView;
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
