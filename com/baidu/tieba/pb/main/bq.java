package com.baidu.tieba.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bq implements Runnable {
    final /* synthetic */ bm a;
    private final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bm bmVar, boolean z) {
        this.a = bmVar;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BdListView bdListView;
        bdListView = this.a.o;
        bdListView.setEnabled(this.b);
    }
}
