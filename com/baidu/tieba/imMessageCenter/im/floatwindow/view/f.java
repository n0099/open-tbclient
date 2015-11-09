package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e bME;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.bME = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Animation Zb;
        if (this.bME.YN()) {
            linearLayout = this.bME.bMu;
            linearLayout.clearAnimation();
            linearLayout2 = this.bME.bMu;
            Zb = this.bME.Zb();
            linearLayout2.startAnimation(Zb);
        }
    }
}
