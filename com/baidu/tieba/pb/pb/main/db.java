package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class db implements com.baidu.tieba.pb.b.c {
    final /* synthetic */ cj bMC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(cj cjVar) {
        this.bMC = cjVar;
    }

    @Override // com.baidu.tieba.pb.b.c
    public void KB() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        if (!this.bMC.abg()) {
            bdTypeListView = this.bMC.aKe;
            if (bdTypeListView != null) {
                bdTypeListView2 = this.bMC.aKe;
                bdTypeListView2.setSelection(0);
            }
        }
    }

    @Override // com.baidu.tieba.pb.b.c
    public void KA() {
        PbActivity pbActivity;
        pbActivity = this.bMC.bIT;
        pbActivity.Jz();
    }
}
