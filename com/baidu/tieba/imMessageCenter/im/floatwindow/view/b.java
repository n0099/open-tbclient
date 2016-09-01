package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a dpv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dpv = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrameLayout frameLayout;
        Animation axP;
        frameLayout = this.dpv.dpg;
        axP = this.dpv.axP();
        frameLayout.startAnimation(axP);
    }
}
