package com.baidu.tieba.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements Runnable {
    final /* synthetic */ x bnY;
    private final /* synthetic */ int val$pos;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(x xVar, int i) {
        this.bnY = xVar;
        this.val$pos = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.bnY.aoo;
        bdListView.setSelection(this.val$pos);
    }
}
