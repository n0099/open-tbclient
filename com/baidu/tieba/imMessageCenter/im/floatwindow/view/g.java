package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.g.d {
    final /* synthetic */ e bIm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.bIm = eVar;
    }

    @Override // com.baidu.adp.lib.g.d, android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.bIm.bIg = true;
    }

    @Override // com.baidu.adp.lib.g.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        Animation animation2;
        this.bIm.bIg = false;
        animation2 = this.bIm.bIj;
        if (animation == animation2 && this.bIm.XM()) {
            this.bIm.XO();
        }
    }
}
