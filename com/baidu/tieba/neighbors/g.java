package com.baidu.tieba.neighbors;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.adp.widget.ListView.f {
    final /* synthetic */ NeighborsActivity btV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(NeighborsActivity neighborsActivity) {
        this.btV = neighborsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        BdListView bdListView;
        if (!com.baidu.adp.lib.util.m.isNetOk()) {
            bdListView = this.btV.btK;
            bdListView.hN();
            return;
        }
        this.btV.VT();
        this.btV.dT(false);
    }
}
