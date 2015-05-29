package com.baidu.tieba.postsearch;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ l bXY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar) {
        this.bXY = lVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PostSearchActivity postSearchActivity;
        BdListView bdListView;
        aVar.dismiss();
        postSearchActivity = this.bXY.bXM;
        postSearchActivity.afW().agi();
        bdListView = this.bXY.bXU;
        bdListView.setVisibility(8);
        this.bXY.showNoDataView();
    }
}
