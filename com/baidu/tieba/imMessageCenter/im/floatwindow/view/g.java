package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f buw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.buw = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Animation Wt;
        if (this.buw.Wf()) {
            linearLayout = this.buw.bum;
            linearLayout.clearAnimation();
            linearLayout2 = this.buw.bum;
            Wt = this.buw.Wt();
            linearLayout2.startAnimation(Wt);
        }
    }
}
