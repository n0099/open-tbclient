package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.pb.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class co implements a.InterfaceC0067a {
    final /* synthetic */ cb cgg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(cb cbVar) {
        this.cgg = cbVar;
    }

    @Override // com.baidu.tieba.pb.b.a.InterfaceC0067a
    public void Mk() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.cgg.aVN;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.cgg.aVN;
            bdTypeListView2.setSelection(0);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.InterfaceC0067a
    public void Mj() {
        PbActivity pbActivity;
        pbActivity = this.cgg.ccs;
        pbActivity.Lk();
    }
}
