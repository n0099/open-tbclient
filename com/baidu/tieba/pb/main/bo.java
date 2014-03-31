package com.baidu.tieba.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bo implements Runnable {
    final /* synthetic */ bk a;
    private final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bk bkVar, boolean z) {
        this.a = bkVar;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BdListView bdListView;
        bdListView = this.a.o;
        bdListView.setEnabled(this.b);
    }
}
