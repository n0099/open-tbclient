package com.baidu.tieba.neighbors;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.core.view.u {
    final /* synthetic */ NeighborsActivity btV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(NeighborsActivity neighborsActivity) {
        this.btV = neighborsActivity;
    }

    @Override // com.baidu.tbadk.core.view.u
    public void aa(boolean z) {
        BdListView bdListView;
        if (z) {
            bdListView = this.btV.btK;
            bdListView.hO();
        }
    }
}
