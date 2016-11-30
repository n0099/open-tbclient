package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements Runnable {
    private final /* synthetic */ boolean eCU;
    final /* synthetic */ ao eFb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ao aoVar, boolean z) {
        this.eFb = aoVar;
        this.eCU = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.eFb.Cj;
        bdListView.setEnabled(this.eCU);
    }
}
