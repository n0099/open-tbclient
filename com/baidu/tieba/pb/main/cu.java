package com.baidu.tieba.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cu implements Runnable {
    final /* synthetic */ bt a;
    private final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(bt btVar, boolean z) {
        this.a = btVar;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.a.m;
        bdListView.setEnabled(this.b);
    }
}
