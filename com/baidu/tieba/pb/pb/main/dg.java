package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dg implements Runnable {
    final /* synthetic */ cj bMC;
    private final /* synthetic */ boolean bMJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dg(cj cjVar, boolean z) {
        this.bMC = cjVar;
        this.bMJ = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.bMC.aKe;
        bdTypeListView.setEnabled(this.bMJ);
    }
}
