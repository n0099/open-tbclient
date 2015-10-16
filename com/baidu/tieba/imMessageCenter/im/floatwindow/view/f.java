package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e bMj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.bMj = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Animation YK;
        if (this.bMj.Yw()) {
            linearLayout = this.bMj.bLZ;
            linearLayout.clearAnimation();
            linearLayout2 = this.bMj.bLZ;
            YK = this.bMj.YK();
            linearLayout2.startAnimation(YK);
        }
    }
}
