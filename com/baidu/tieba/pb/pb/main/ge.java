package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.pb.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ge implements a.InterfaceC0066a {
    final /* synthetic */ ey etN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ge(ey eyVar) {
        this.etN = eyVar;
    }

    @Override // com.baidu.tieba.pb.a.a.InterfaceC0066a
    public void abu() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        com.baidu.tieba.pb.video.d dVar;
        bdTypeListView = this.etN.mListView;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.etN.mListView;
            bdTypeListView2.setSelection(0);
            dVar = this.etN.erf;
            dVar.aQs();
        }
    }

    @Override // com.baidu.tieba.pb.a.a.InterfaceC0066a
    public void abt() {
        PbActivity pbActivity;
        pbActivity = this.etN.ekw;
        pbActivity.aar();
    }
}
