package com.baidu.tieba.im.view;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class q implements Animation.AnimationListener {
    final /* synthetic */ ShutDownValidateTipView bqC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ShutDownValidateTipView shutDownValidateTipView) {
        this.bqC = shutDownValidateTipView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.bqC.setVisibility(8);
    }
}
