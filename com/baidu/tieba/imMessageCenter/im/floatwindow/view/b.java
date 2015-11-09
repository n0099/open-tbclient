package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bMt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bMt = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrameLayout frameLayout;
        Animation Zb;
        frameLayout = this.bMt.bMf;
        Zb = this.bMt.Zb();
        frameLayout.startAnimation(Zb);
    }
}
