package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e ddY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.ddY = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Animation atb;
        if (this.ddY.asN()) {
            linearLayout = this.ddY.ddO;
            linearLayout.clearAnimation();
            linearLayout2 = this.ddY.ddO;
            atb = this.ddY.atb();
            linearLayout2.startAnimation(atb);
        }
    }
}
