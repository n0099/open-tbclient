package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.pb.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dy implements a.InterfaceC0078a {
    final /* synthetic */ da cGh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dy(da daVar) {
        this.cGh = daVar;
    }

    @Override // com.baidu.tieba.pb.b.a.InterfaceC0078a
    public void NX() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.cGh.aRs;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.cGh.aRs;
            bdTypeListView2.setSelection(0);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.InterfaceC0078a
    public void NW() {
        PbActivity pbActivity;
        pbActivity = this.cGh.cCy;
        pbActivity.MS();
    }
}
