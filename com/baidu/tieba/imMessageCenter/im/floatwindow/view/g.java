package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f brt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.brt = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Animation UO;
        if (this.brt.UA()) {
            linearLayout = this.brt.brj;
            linearLayout.clearAnimation();
            linearLayout2 = this.brt.brj;
            UO = this.brt.UO();
            linearLayout2.startAnimation(UO);
        }
    }
}
