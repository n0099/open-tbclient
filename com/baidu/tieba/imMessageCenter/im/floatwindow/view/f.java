package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e bIT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.bIT = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Animation Yc;
        if (this.bIT.XO()) {
            linearLayout = this.bIT.bIJ;
            linearLayout.clearAnimation();
            linearLayout2 = this.bIT.bIJ;
            Yc = this.bIT.Yc();
            linearLayout2.startAnimation(Yc);
        }
    }
}
