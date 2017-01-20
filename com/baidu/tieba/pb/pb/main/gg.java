package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.pb.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gg implements a.InterfaceC0068a {
    final /* synthetic */ ez eqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gg(ez ezVar) {
        this.eqf = ezVar;
    }

    @Override // com.baidu.tieba.pb.a.a.InterfaceC0068a
    public void YW() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.eqf.mListView;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.eqf.mListView;
            bdTypeListView2.setSelection(0);
        }
    }

    @Override // com.baidu.tieba.pb.a.a.InterfaceC0068a
    public void YV() {
        PbActivity pbActivity;
        pbActivity = this.eqf.ehi;
        pbActivity.XV();
    }
}
