package com.baidu.tieba.neighbors;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.adp.widget.ListView.f {
    final /* synthetic */ NeighborsActivity buj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(NeighborsActivity neighborsActivity) {
        this.buj = neighborsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        BdListView bdListView;
        if (!com.baidu.adp.lib.util.m.isNetOk()) {
            bdListView = this.buj.btY;
            bdListView.hN();
            return;
        }
        this.buj.VW();
        this.buj.dT(false);
    }
}
