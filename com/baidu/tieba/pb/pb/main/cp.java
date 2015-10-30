package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.pb.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cp implements a.InterfaceC0070a {
    final /* synthetic */ cc clJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(cc ccVar) {
        this.clJ = ccVar;
    }

    @Override // com.baidu.tieba.pb.b.a.InterfaceC0070a
    public void Mf() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.clJ.aVg;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.clJ.aVg;
            bdTypeListView2.setSelection(0);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.InterfaceC0070a
    public void Me() {
        PbActivity pbActivity;
        pbActivity = this.clJ.ciU;
        pbActivity.Lc();
    }
}
