package com.baidu.tieba.postsearch;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements a.b {
    final /* synthetic */ l dxN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar) {
        this.dxN = lVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        PostSearchActivity postSearchActivity;
        BdListView bdListView;
        aVar.dismiss();
        postSearchActivity = this.dxN.dxA;
        postSearchActivity.aCM().aCY();
        bdListView = this.dxN.dxJ;
        bdListView.setVisibility(8);
        this.dxN.showNoDataView();
    }
}
