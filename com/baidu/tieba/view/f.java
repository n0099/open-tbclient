package com.baidu.tieba.view;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {
    final /* synthetic */ CommonTipView fAW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(CommonTipView commonTipView) {
        this.fAW = commonTipView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        Runnable runnable;
        int i;
        CommonTipView commonTipView = this.fAW;
        runnable = this.fAW.cqF;
        i = this.fAW.zC;
        commonTipView.postDelayed(runnable, i);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
