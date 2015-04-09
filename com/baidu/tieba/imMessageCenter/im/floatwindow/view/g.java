package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f brJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.brJ = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Animation Vb;
        if (this.brJ.UN()) {
            linearLayout = this.brJ.brz;
            linearLayout.clearAnimation();
            linearLayout2 = this.brJ.brz;
            Vb = this.brJ.Vb();
            linearLayout2.startAnimation(Vb);
        }
    }
}
