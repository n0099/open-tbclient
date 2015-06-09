package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cu implements com.baidu.tieba.pb.b.c {
    final /* synthetic */ ch bOG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(ch chVar) {
        this.bOG = chVar;
    }

    @Override // com.baidu.tieba.pb.b.c
    public void LH() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.bOG.aMm;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.bOG.aMm;
            bdTypeListView2.setSelection(0);
        }
    }

    @Override // com.baidu.tieba.pb.b.c
    public void LG() {
        PbActivity pbActivity;
        pbActivity = this.bOG.bLa;
        pbActivity.KE();
    }
}
