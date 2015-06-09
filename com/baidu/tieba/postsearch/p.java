package com.baidu.tieba.postsearch;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ l bXZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar) {
        this.bXZ = lVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PostSearchActivity postSearchActivity;
        BdListView bdListView;
        aVar.dismiss();
        postSearchActivity = this.bXZ.bXN;
        postSearchActivity.afX().agj();
        bdListView = this.bXZ.bXV;
        bdListView.setVisibility(8);
        this.bXZ.showNoDataView();
    }
}
