package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.lib.h.d {
    final /* synthetic */ FloatingPersonalChatView cvr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(FloatingPersonalChatView floatingPersonalChatView) {
        this.cvr = floatingPersonalChatView;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        h hVar;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Runnable runnable;
        hVar = this.cvr.cvg;
        if (hVar.d(animation)) {
            linearLayout = this.cvr.cvf;
            if (linearLayout != null) {
                linearLayout2 = this.cvr.cvf;
                runnable = this.cvr.cuz;
                linearLayout2.removeCallbacks(runnable);
            }
            com.baidu.tieba.imMessageCenter.im.floatwindow.b.ajq().eC(false);
            this.cvr.cvm = true;
        }
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        h hVar;
        hVar = this.cvr.cvg;
        if (!hVar.d(animation)) {
            return;
        }
        this.cvr.Dv();
    }
}
