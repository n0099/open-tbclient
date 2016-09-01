package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fa implements Runnable {
    final /* synthetic */ ex euB;
    private final /* synthetic */ boolean euC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fa(ex exVar, boolean z) {
        this.euB = exVar;
        this.euC = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdTypeListView bdTypeListView;
        bdTypeListView = this.euB.bBT;
        bdTypeListView.setEnabled(this.euC);
    }
}
