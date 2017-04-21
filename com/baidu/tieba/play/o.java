package com.baidu.tieba.play;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ c eWq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(c cVar) {
        this.eWq = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        View view3;
        view = this.eWq.aTl;
        view.setVisibility(0);
        view2 = this.eWq.cKY;
        view2.setVisibility(8);
        view3 = this.eWq.eWd;
        view3.setVisibility(8);
    }
}
