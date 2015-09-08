package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cs implements Runnable {
    final /* synthetic */ cb cgg;
    private final /* synthetic */ boolean cgh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(cb cbVar, boolean z) {
        this.cgg = cbVar;
        this.cgh = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.cgg.aVN;
        bdTypeListView.setEnabled(this.cgh);
    }
}
