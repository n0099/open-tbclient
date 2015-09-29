package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e bLY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.bLY = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Animation YK;
        if (this.bLY.Yw()) {
            linearLayout = this.bLY.bLO;
            linearLayout.clearAnimation();
            linearLayout2 = this.bLY.bLO;
            YK = this.bLY.YK();
            linearLayout2.startAnimation(YK);
        }
    }
}
