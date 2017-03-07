package com.baidu.tieba.play;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ c eWb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(c cVar) {
        this.eWb = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        View view3;
        view = this.eWb.aSU;
        view.setVisibility(0);
        view2 = this.eWb.bXW;
        view2.setVisibility(8);
        view3 = this.eWb.eVO;
        view3.setVisibility(8);
    }
}
