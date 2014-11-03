package com.baidu.tieba.im.view;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class q implements Animation.AnimationListener {
    final /* synthetic */ ShutDownValidateTipView bjU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ShutDownValidateTipView shutDownValidateTipView) {
        this.bjU = shutDownValidateTipView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.bjU.setVisibility(8);
    }
}
