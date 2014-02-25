package com.baidu.tieba.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Runnable {
    final /* synthetic */ l a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(l lVar, int i) {
        this.a = lVar;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.a.e;
        bdListView.setSelection(this.b);
    }
}
