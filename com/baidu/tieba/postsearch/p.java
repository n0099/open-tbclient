package com.baidu.tieba.postsearch;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements a.b {
    final /* synthetic */ l djT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar) {
        this.djT = lVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PostSearchActivity postSearchActivity;
        BdListView bdListView;
        aVar.dismiss();
        postSearchActivity = this.djT.djG;
        postSearchActivity.awr().awC();
        bdListView = this.djT.djP;
        bdListView.setVisibility(8);
        this.djT.showNoDataView();
    }
}
