package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fb implements Runnable {
    final /* synthetic */ ey eCT;
    private final /* synthetic */ boolean eCU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fb(ey eyVar, boolean z) {
        this.eCT = eyVar;
        this.eCU = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.eCT.aML;
        bdTypeListView.setEnabled(this.eCU);
    }
}
