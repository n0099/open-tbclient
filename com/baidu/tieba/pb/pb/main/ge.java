package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.pb.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ge implements a.InterfaceC0066a {
    final /* synthetic */ ey erv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ge(ey eyVar) {
        this.erv = eyVar;
    }

    @Override // com.baidu.tieba.pb.a.a.InterfaceC0066a
    public void aat() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        com.baidu.tieba.pb.video.d dVar;
        bdTypeListView = this.erv.mListView;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.erv.mListView;
            bdTypeListView2.setSelection(0);
            dVar = this.erv.eoO;
            dVar.aPr();
        }
    }

    @Override // com.baidu.tieba.pb.a.a.InterfaceC0066a
    public void aas() {
        PbActivity pbActivity;
        pbActivity = this.erv.eig;
        pbActivity.Zq();
    }
}
