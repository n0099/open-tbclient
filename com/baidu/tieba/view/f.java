package com.baidu.tieba.view;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {
    final /* synthetic */ CommonTipView fZX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(CommonTipView commonTipView) {
        this.fZX = commonTipView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        Runnable runnable;
        int i;
        CommonTipView commonTipView = this.fZX;
        runnable = this.fZX.cfo;
        i = this.fZX.Ii;
        commonTipView.postDelayed(runnable, i);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
