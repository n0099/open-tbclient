package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eu implements Runnable {
    final /* synthetic */ er egZ;
    private final /* synthetic */ boolean eha;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eu(er erVar, boolean z) {
        this.egZ = erVar;
        this.eha = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.egZ.aMc;
        bdTypeListView.setEnabled(this.eha);
    }
}
