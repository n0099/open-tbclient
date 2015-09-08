package com.baidu.tieba.postsearch;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements a.b {
    final /* synthetic */ k cxp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(k kVar) {
        this.cxp = kVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PostSearchActivity postSearchActivity;
        BdListView bdListView;
        aVar.dismiss();
        postSearchActivity = this.cxp.cxd;
        postSearchActivity.ama().aml();
        bdListView = this.cxp.cxl;
        bdListView.setVisibility(8);
        this.cxp.showNoDataView();
    }
}
