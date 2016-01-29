package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.pb.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fb implements a.InterfaceC0075a {
    final /* synthetic */ dz cSw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fb(dz dzVar) {
        this.cSw = dzVar;
    }

    @Override // com.baidu.tieba.pb.b.a.InterfaceC0075a
    public void Qt() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.cSw.aXu;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.cSw.aXu;
            bdTypeListView2.setSelection(0);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.InterfaceC0075a
    public void Qs() {
        PbActivity pbActivity;
        pbActivity = this.cSw.cNL;
        pbActivity.Pj();
    }
}
