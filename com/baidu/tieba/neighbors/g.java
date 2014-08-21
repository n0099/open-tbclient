package com.baidu.tieba.neighbors;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements r {
    final /* synthetic */ NeighborsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(NeighborsActivity neighborsActivity) {
        this.a = neighborsActivity;
    }

    @Override // com.baidu.tbadk.core.view.r
    public void a(boolean z) {
        BdListView bdListView;
        if (z) {
            bdListView = this.a.o;
            bdListView.e();
        }
    }
}
