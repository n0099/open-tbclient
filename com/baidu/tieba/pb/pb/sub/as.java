package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements Runnable {
    final /* synthetic */ ao eIl;
    private final /* synthetic */ boolean eIn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ao aoVar, boolean z) {
        this.eIl = aoVar;
        this.eIn = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.eIl.Ib;
        bdListView.setEnabled(this.eIn);
    }
}
