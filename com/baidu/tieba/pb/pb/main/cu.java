package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cu implements com.baidu.tieba.pb.b.c {
    final /* synthetic */ ch bOF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(ch chVar) {
        this.bOF = chVar;
    }

    @Override // com.baidu.tieba.pb.b.c
    public void LG() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.bOF.aMl;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.bOF.aMl;
            bdTypeListView2.setSelection(0);
        }
    }

    @Override // com.baidu.tieba.pb.b.c
    public void LF() {
        PbActivity pbActivity;
        pbActivity = this.bOF.bKZ;
        pbActivity.KD();
    }
}
