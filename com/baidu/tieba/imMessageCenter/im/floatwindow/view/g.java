package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.h.d {
    final /* synthetic */ e cfI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.cfI = eVar;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.cfI.cfC = true;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        Animation animation2;
        this.cfI.cfC = false;
        animation2 = this.cfI.cfF;
        if (animation == animation2 && this.cfI.adc()) {
            this.cfI.ade();
        }
    }
}
