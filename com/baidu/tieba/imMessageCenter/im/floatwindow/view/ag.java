package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.lib.h.d {
    final /* synthetic */ FloatingPersonalChatView ccl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(FloatingPersonalChatView floatingPersonalChatView) {
        this.ccl = floatingPersonalChatView;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        h hVar;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Runnable runnable;
        hVar = this.ccl.cca;
        if (hVar.d(animation)) {
            linearLayout = this.ccl.cbZ;
            if (linearLayout != null) {
                linearLayout2 = this.ccl.cbZ;
                runnable = this.ccl.cbu;
                linearLayout2.removeCallbacks(runnable);
            }
            com.baidu.tieba.imMessageCenter.im.floatwindow.b.abE().dZ(false);
            this.ccl.ccg = true;
        }
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        h hVar;
        hVar = this.ccl.cca;
        if (!hVar.d(animation)) {
            return;
        }
        this.ccl.BH();
    }
}
