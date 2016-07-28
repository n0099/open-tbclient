package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.h.d {
    final /* synthetic */ e ddY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.ddY = eVar;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.ddY.ddT = true;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        Animation animation2;
        this.ddY.ddT = false;
        animation2 = this.ddY.ddW;
        if (animation == animation2 && this.ddY.asN()) {
            this.ddY.asP();
        }
    }
}
