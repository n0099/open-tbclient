package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.pb.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cp implements a.InterfaceC0070a {
    final /* synthetic */ cc cly;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(cc ccVar) {
        this.cly = ccVar;
    }

    @Override // com.baidu.tieba.pb.b.a.InterfaceC0070a
    public void Mj() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.cly.aUV;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.cly.aUV;
            bdTypeListView2.setSelection(0);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.InterfaceC0070a
    public void Mi() {
        PbActivity pbActivity;
        pbActivity = this.cly.ciJ;
        pbActivity.Lg();
    }
}
