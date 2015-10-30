package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.lib.g.d {
    final /* synthetic */ FloatingPersonalChatView bMM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(FloatingPersonalChatView floatingPersonalChatView) {
        this.bMM = floatingPersonalChatView;
    }

    @Override // com.baidu.adp.lib.g.d, android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        h hVar;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Runnable runnable;
        hVar = this.bMM.bMB;
        if (hVar.d(animation)) {
            linearLayout = this.bMM.bMA;
            if (linearLayout != null) {
                linearLayout2 = this.bMM.bMA;
                runnable = this.bMM.bLV;
                linearLayout2.removeCallbacks(runnable);
            }
            com.baidu.tieba.imMessageCenter.im.floatwindow.b.Yd().dC(false);
            this.bMM.bMH = true;
        }
    }

    @Override // com.baidu.adp.lib.g.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        h hVar;
        hVar = this.bMM.bMB;
        if (!hVar.d(animation)) {
            return;
        }
        this.bMM.AD();
    }
}
