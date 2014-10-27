package com.baidu.tieba.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements Runnable {
    final /* synthetic */ x bnK;
    private final /* synthetic */ int val$pos;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(x xVar, int i) {
        this.bnK = xVar;
        this.val$pos = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.bnK.aof;
        bdListView.setSelection(this.val$pos);
    }
}
