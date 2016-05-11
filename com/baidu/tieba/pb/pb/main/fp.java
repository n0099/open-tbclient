package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.pb.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fp implements a.InterfaceC0067a {
    final /* synthetic */ el dpu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fp(el elVar) {
        this.dpu = elVar;
    }

    @Override // com.baidu.tieba.pb.a.a.InterfaceC0067a
    public void Rs() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.dpu.bej;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.dpu.bej;
            bdTypeListView2.setSelection(0);
        }
    }

    @Override // com.baidu.tieba.pb.a.a.InterfaceC0067a
    public void Rr() {
        PbActivity pbActivity;
        pbActivity = this.dpu.dhY;
        pbActivity.PY();
    }
}
