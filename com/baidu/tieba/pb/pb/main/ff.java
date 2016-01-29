package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ff implements Runnable {
    private final /* synthetic */ boolean cSB;
    final /* synthetic */ dz cSw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ff(dz dzVar, boolean z) {
        this.cSw = dzVar;
        this.cSB = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.cSw.aXu;
        bdTypeListView.setEnabled(this.cSB);
    }
}
