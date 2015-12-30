package com.baidu.tieba.recommendfrs;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements BdListView.e {
    final /* synthetic */ e doc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.doc = eVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        PbListView pbListView;
        n nVar;
        PbListView pbListView2;
        pbListView = this.doc.aVj;
        if (pbListView != null) {
            pbListView2 = this.doc.aVj;
            pbListView2.startLoadData();
        }
        nVar = this.doc.dnZ;
        nVar.loadMore();
    }
}
