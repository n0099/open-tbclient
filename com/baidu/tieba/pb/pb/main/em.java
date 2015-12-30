package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class em implements Runnable {
    final /* synthetic */ dk cKg;
    private final /* synthetic */ boolean cKj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public em(dk dkVar, boolean z) {
        this.cKg = dkVar;
        this.cKj = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.cKg.aVi;
        bdTypeListView.setEnabled(this.cKj);
    }
}
