package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.pb.b.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class co implements a.InterfaceC0065a {
    final /* synthetic */ cb cfj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(cb cbVar) {
        this.cfj = cbVar;
    }

    @Override // com.baidu.tieba.pb.b.a.InterfaceC0065a
    public void Mt() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.cfj.aVy;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.cfj.aVy;
            bdTypeListView2.setSelection(0);
        }
    }

    @Override // com.baidu.tieba.pb.b.a.InterfaceC0065a
    public void Ms() {
        PbActivity pbActivity;
        pbActivity = this.cfj.cbx;
        pbActivity.Lt();
    }
}
