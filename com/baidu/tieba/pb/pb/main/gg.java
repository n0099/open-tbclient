package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.pb.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gg implements a.InterfaceC0067a {
    final /* synthetic */ fa etn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gg(fa faVar) {
        this.etn = faVar;
    }

    @Override // com.baidu.tieba.pb.a.a.InterfaceC0067a
    public void ZV() {
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        com.baidu.tieba.pb.video.d dVar;
        bdTypeListView = this.etn.mListView;
        if (bdTypeListView != null) {
            bdTypeListView2 = this.etn.mListView;
            bdTypeListView2.setSelection(0);
            dVar = this.etn.eqF;
            dVar.aPi();
        }
    }

    @Override // com.baidu.tieba.pb.a.a.InterfaceC0067a
    public void ZU() {
        PbActivity pbActivity;
        pbActivity = this.etn.eka;
        pbActivity.YU();
    }
}
