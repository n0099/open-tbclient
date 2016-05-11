package com.baidu.tieba.postsearch;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements a.b {
    final /* synthetic */ l dVl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar) {
        this.dVl = lVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        PostSearchActivity postSearchActivity;
        BdListView bdListView;
        aVar.dismiss();
        postSearchActivity = this.dVl.dUY;
        postSearchActivity.aKE().aKQ();
        bdListView = this.dVl.dVh;
        bdListView.setVisibility(8);
        this.dVl.showNoDataView();
    }
}
