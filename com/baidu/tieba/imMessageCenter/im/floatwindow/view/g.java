package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.h.d {
    final /* synthetic */ e dwK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.dwK = eVar;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.dwK.dwF = true;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        Animation animation2;
        this.dwK.dwF = false;
        animation2 = this.dwK.dwI;
        if (animation == animation2 && this.dwK.azX()) {
            this.dwK.azZ();
        }
    }
}
