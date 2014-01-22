package com.baidu.tieba.pb;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dq implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ cr b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dq(cr crVar, boolean z) {
        this.b = crVar;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.b.i;
        bdListView.setEnabled(this.a);
    }
}
