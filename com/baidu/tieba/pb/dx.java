package com.baidu.tieba.pb;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dx implements Runnable {
    final /* synthetic */ cu a;
    private final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dx(cu cuVar, boolean z) {
        this.a = cuVar;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.a.j;
        bdListView.setEnabled(this.b);
    }
}
