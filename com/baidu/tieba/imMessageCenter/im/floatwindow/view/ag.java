package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.lib.h.d {
    final /* synthetic */ FloatingPersonalChatView cgl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(FloatingPersonalChatView floatingPersonalChatView) {
        this.cgl = floatingPersonalChatView;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        h hVar;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Runnable runnable;
        hVar = this.cgl.cga;
        if (hVar.d(animation)) {
            linearLayout = this.cgl.cfZ;
            if (linearLayout != null) {
                linearLayout2 = this.cgl.cfZ;
                runnable = this.cgl.cfu;
                linearLayout2.removeCallbacks(runnable);
            }
            com.baidu.tieba.imMessageCenter.im.floatwindow.b.acN().dZ(false);
            this.cgl.cgg = true;
        }
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        h hVar;
        hVar = this.cgl.cga;
        if (!hVar.d(animation)) {
            return;
        }
        this.cgl.Bw();
    }
}
