package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.h.d {
    final /* synthetic */ e cuO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.cuO = eVar;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.cuO.cuI = true;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        Animation animation2;
        this.cuO.cuI = false;
        animation2 = this.cuO.cuL;
        if (animation == animation2 && this.cuO.ajF()) {
            this.cuO.ajH();
        }
    }
}
