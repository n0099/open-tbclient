package com.baidu.tieba.recommendfrs;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements Animation.AnimationListener {
    final /* synthetic */ p dDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(p pVar) {
        this.dDT = pVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        Runnable runnable;
        int i;
        com.baidu.adp.lib.h.h hr = com.baidu.adp.lib.h.h.hr();
        runnable = this.dDT.cSv;
        i = this.dDT.dDJ;
        hr.postDelayed(runnable, i);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
