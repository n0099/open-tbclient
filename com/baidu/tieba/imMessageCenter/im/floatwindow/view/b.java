package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a daQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.daQ = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrameLayout frameLayout;
        Animation asp;
        frameLayout = this.daQ.daC;
        asp = this.daQ.asp();
        frameLayout.startAnimation(asp);
    }
}
