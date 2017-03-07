package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fe implements Runnable {
    final /* synthetic */ fa etn;
    private final /* synthetic */ boolean eto;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fe(fa faVar, boolean z) {
        this.etn = faVar;
        this.eto = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.etn.mListView;
        bdTypeListView.setEnabled(this.eto);
    }
}
