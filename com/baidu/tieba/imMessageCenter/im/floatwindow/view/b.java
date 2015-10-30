package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bLY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bLY = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrameLayout frameLayout;
        Animation YG;
        frameLayout = this.bLY.bLK;
        YG = this.bLY.YG();
        frameLayout.startAnimation(YG);
    }
}
