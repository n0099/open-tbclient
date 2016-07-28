package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.pb.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ga implements a.InterfaceC0071a {
    final /* synthetic */ ew eiu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ga(ew ewVar) {
        this.eiu = ewVar;
    }

    @Override // com.baidu.tieba.pb.a.a.InterfaceC0071a
    public void Xh() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        bdTypeListView = this.eiu.bqG;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.eiu.bqG;
            bdTypeListView2.setSelection(0);
        }
    }

    @Override // com.baidu.tieba.pb.a.a.InterfaceC0071a
    public void Xg() {
        PbActivity pbActivity;
        pbActivity = this.eiu.eat;
        pbActivity.VT();
    }
}
