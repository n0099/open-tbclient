package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bLN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bLN = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrameLayout frameLayout;
        Animation YK;
        frameLayout = this.bLN.bLz;
        YK = this.bLN.YK();
        frameLayout.startAnimation(YK);
    }
}
