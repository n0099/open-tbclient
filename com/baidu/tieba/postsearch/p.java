package com.baidu.tieba.postsearch;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements a.b {
    final /* synthetic */ l dSt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar) {
        this.dSt = lVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        PostSearchActivity postSearchActivity;
        BdListView bdListView;
        aVar.dismiss();
        postSearchActivity = this.dSt.dSg;
        postSearchActivity.aKA().aKM();
        bdListView = this.dSt.dSp;
        bdListView.setVisibility(8);
        this.dSt.showNoDataView();
    }
}
