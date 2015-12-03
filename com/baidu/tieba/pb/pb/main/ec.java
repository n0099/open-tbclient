package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ec implements Runnable {
    final /* synthetic */ da cGh;
    private final /* synthetic */ boolean cGk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ec(da daVar, boolean z) {
        this.cGh = daVar;
        this.cGk = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.cGh.aRs;
        bdTypeListView.setEnabled(this.cGk);
    }
}
