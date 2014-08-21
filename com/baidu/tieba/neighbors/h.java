package com.baidu.tieba.neighbors;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ NeighborsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(NeighborsActivity neighborsActivity) {
        this.a = neighborsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void a(boolean z) {
        BdListView bdListView;
        if (!com.baidu.adp.lib.util.j.c()) {
            bdListView = this.a.o;
            bdListView.d();
            return;
        }
        this.a.m();
        this.a.b(false);
    }
}
