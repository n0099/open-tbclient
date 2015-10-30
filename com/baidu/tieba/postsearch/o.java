package com.baidu.tieba.postsearch;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements a.b {
    final /* synthetic */ k cEi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(k kVar) {
        this.cEi = kVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PostSearchActivity postSearchActivity;
        BdListView bdListView;
        aVar.dismiss();
        postSearchActivity = this.cEi.cDW;
        postSearchActivity.aog().aor();
        bdListView = this.cEi.cEe;
        bdListView.setVisibility(8);
        this.cEi.showNoDataView();
    }
}
