package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fe implements Runnable {
    final /* synthetic */ ez eqf;
    private final /* synthetic */ boolean eqh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fe(ez ezVar, boolean z) {
        this.eqf = ezVar;
        this.eqh = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.eqf.mListView;
        bdTypeListView.setEnabled(this.eqh);
    }
}
