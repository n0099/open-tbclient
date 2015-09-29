package com.baidu.tieba.postsearch;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements a.b {
    final /* synthetic */ k cDX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(k kVar) {
        this.cDX = kVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PostSearchActivity postSearchActivity;
        BdListView bdListView;
        aVar.dismiss();
        postSearchActivity = this.cDX.cDL;
        postSearchActivity.aok().aov();
        bdListView = this.cDX.cDT;
        bdListView.setVisibility(8);
        this.cDX.showNoDataView();
    }
}
