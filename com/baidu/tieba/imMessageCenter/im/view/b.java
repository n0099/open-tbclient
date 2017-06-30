package com.baidu.tieba.imMessageCenter.im.view;

import android.view.animation.Animation;
/* loaded from: classes2.dex */
class b implements Animation.AnimationListener {
    final /* synthetic */ ShutDownValidateTipView dtQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ShutDownValidateTipView shutDownValidateTipView) {
        this.dtQ = shutDownValidateTipView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.dtQ.setVisibility(8);
    }
}
