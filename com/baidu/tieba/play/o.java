package com.baidu.tieba.play;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ c fbb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(c cVar) {
        this.fbb = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        View view3;
        view = this.fbb.bCL;
        view.setVisibility(0);
        view2 = this.fbb.cKz;
        view2.setVisibility(8);
        view3 = this.fbb.faN;
        view3.setVisibility(8);
    }
}
