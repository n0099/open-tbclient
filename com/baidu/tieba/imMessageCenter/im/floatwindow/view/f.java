package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e bIm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.bIm = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Animation Ya;
        if (this.bIm.XM()) {
            linearLayout = this.bIm.bIc;
            linearLayout.clearAnimation();
            linearLayout2 = this.bIm.bIc;
            Ya = this.bIm.Ya();
            linearLayout2.startAnimation(Ya);
        }
    }
}
