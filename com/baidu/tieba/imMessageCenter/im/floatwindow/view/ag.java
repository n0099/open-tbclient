package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.lib.h.d {
    final /* synthetic */ FloatingPersonalChatView deC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(FloatingPersonalChatView floatingPersonalChatView) {
        this.deC = floatingPersonalChatView;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        h hVar;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Runnable runnable;
        hVar = this.deC.deq;
        if (hVar.d(animation)) {
            linearLayout = this.deC.dep;
            if (linearLayout != null) {
                linearLayout2 = this.deC.dep;
                runnable = this.deC.ddK;
                linearLayout2.removeCallbacks(runnable);
            }
            com.baidu.tieba.imMessageCenter.im.floatwindow.b.asy().fV(false);
            this.deC.dex = true;
        }
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        h hVar;
        hVar = this.deC.deq;
        if (!hVar.d(animation)) {
            return;
        }
        this.deC.Bz();
    }
}
