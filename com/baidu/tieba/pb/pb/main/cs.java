package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cs implements Runnable {
    final /* synthetic */ cb cfj;
    private final /* synthetic */ boolean cfk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(cb cbVar, boolean z) {
        this.cfj = cbVar;
        this.cfk = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.cfj.aVy;
        bdTypeListView.setEnabled(this.cfk);
    }
}
