package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.pb.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ei implements a.InterfaceC0073a {
    final /* synthetic */ dk cKg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ei(dk dkVar) {
        this.cKg = dkVar;
    }

    @Override // com.baidu.tieba.pb.b.a.InterfaceC0073a
    public void Oq() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.cKg.aVi;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.cKg.aVi;
            bdTypeListView2.setSelection(0);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.InterfaceC0073a
    public void Op() {
        PbActivity pbActivity;
        pbActivity = this.cKg.cGj;
        pbActivity.Nm();
    }
}
