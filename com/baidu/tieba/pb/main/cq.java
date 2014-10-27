package com.baidu.tieba.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cq implements com.baidu.tieba.c.c {
    final /* synthetic */ bv byI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(bv bvVar) {
        this.byI = bvVar;
    }

    @Override // com.baidu.tieba.c.c
    public void GK() {
        BdListView bdListView;
        BdListView bdListView2;
        bdListView = this.byI.vl;
        if (bdListView != null) {
            bdListView2 = this.byI.vl;
            bdListView2.setSelection(0);
        }
    }

    @Override // com.baidu.tieba.c.c
    public void GJ() {
        PbActivity pbActivity;
        pbActivity = this.byI.bwQ;
        pbActivity.FG();
    }
}
