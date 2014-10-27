package com.baidu.tieba.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cv implements Runnable {
    final /* synthetic */ bv byI;
    private final /* synthetic */ boolean byS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(bv bvVar, boolean z) {
        this.byI = bvVar;
        this.byS = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.byI.vl;
        bdListView.setEnabled(this.byS);
    }
}
