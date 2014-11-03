package com.baidu.tieba.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ c bnx;
    private final /* synthetic */ int val$pos;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar, int i) {
        this.bnx = cVar;
        this.val$pos = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.bnx.aoo;
        bdListView.setSelection(this.val$pos);
    }
}
