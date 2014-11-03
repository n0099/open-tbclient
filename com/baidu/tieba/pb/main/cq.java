package com.baidu.tieba.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cq implements com.baidu.tieba.c.c {
    final /* synthetic */ bv byW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(bv bvVar) {
        this.byW = bvVar;
    }

    @Override // com.baidu.tieba.c.c
    public void GM() {
        BdListView bdListView;
        BdListView bdListView2;
        bdListView = this.byW.vl;
        if (bdListView != null) {
            bdListView2 = this.byW.vl;
            bdListView2.setSelection(0);
        }
    }

    @Override // com.baidu.tieba.c.c
    public void GL() {
        PbActivity pbActivity;
        pbActivity = this.byW.bxe;
        pbActivity.FI();
    }
}
