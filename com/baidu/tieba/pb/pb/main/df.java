package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class df implements Runnable {
    final /* synthetic */ ci bMm;
    private final /* synthetic */ boolean bMt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(ci ciVar, boolean z) {
        this.bMm = ciVar;
        this.bMt = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.bMm.aJU;
        bdTypeListView.setEnabled(this.bMt);
    }
}
