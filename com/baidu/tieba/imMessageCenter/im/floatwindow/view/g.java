package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.h.d {
    final /* synthetic */ e cvL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.cvL = eVar;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.cvL.cvF = true;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        Animation animation2;
        this.cvL.cvF = false;
        animation2 = this.cvL.cvI;
        if (animation == animation2 && this.cvL.ajN()) {
            this.cvL.ajP();
        }
    }
}
