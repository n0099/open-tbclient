package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Runnable {
    private final /* synthetic */ boolean cmZ;
    final /* synthetic */ v coo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(v vVar, boolean z) {
        this.coo = vVar;
        this.cmZ = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        bdListView = this.coo.mListView;
        bdListView.setEnabled(this.cmZ);
    }
}
