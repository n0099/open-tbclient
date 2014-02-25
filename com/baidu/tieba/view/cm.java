package com.baidu.tieba.view;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class cm implements Animation.AnimationListener {
    final /* synthetic */ ShutDownValidateTipView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(ShutDownValidateTipView shutDownValidateTipView) {
        this.a = shutDownValidateTipView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.a.setVisibility(8);
    }
}
