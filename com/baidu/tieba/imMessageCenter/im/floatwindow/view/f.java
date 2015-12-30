package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e cfI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cfI = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Animation adq;
        if (this.cfI.adc()) {
            linearLayout = this.cfI.cfy;
            linearLayout.clearAnimation();
            linearLayout2 = this.cfI.cfy;
            adq = this.cfI.adq();
            linearLayout2.startAnimation(adq);
        }
    }
}
