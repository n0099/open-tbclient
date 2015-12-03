package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a cbx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cbx = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrameLayout frameLayout;
        Animation ach;
        frameLayout = this.cbx.cbj;
        ach = this.cbx.ach();
        frameLayout.startAnimation(ach);
    }
}
