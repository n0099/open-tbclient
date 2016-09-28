package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fa implements Runnable {
    final /* synthetic */ ex ewH;
    private final /* synthetic */ boolean ewI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fa(ex exVar, boolean z) {
        this.ewH = exVar;
        this.ewI = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.ewH.bCe;
        bdTypeListView.setEnabled(this.ewI);
    }
}
