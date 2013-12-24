package com.baidu.tieba.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ j b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(j jVar, int i) {
        this.b = jVar;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.b.e;
        bdListView.setSelection(this.a);
    }
}
