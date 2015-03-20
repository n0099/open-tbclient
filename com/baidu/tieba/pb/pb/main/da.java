package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class da implements com.baidu.tieba.pb.b.c {
    final /* synthetic */ ci bMm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(ci ciVar) {
        this.bMm = ciVar;
    }

    @Override // com.baidu.tieba.pb.b.c
    public void Kr() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        if (!this.bMm.aaT()) {
            bdTypeListView = this.bMm.aJU;
            if (bdTypeListView != null) {
                bdTypeListView2 = this.bMm.aJU;
                bdTypeListView2.setSelection(0);
            }
        }
    }

    @Override // com.baidu.tieba.pb.b.c
    public void Kq() {
        PbActivity pbActivity;
        pbActivity = this.bMm.bIF;
        pbActivity.Jt();
    }
}
