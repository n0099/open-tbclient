package com.baidu.tieba.recommendfrs;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements BdListView.e {
    final /* synthetic */ f dVf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(f fVar) {
        this.dVf = fVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nm() {
        PbListView pbListView;
        q qVar;
        PbListView pbListView2;
        pbListView = this.dVf.bcf;
        if (pbListView != null) {
            pbListView2 = this.dVf.bcf;
            pbListView2.xu();
        }
        qVar = this.dVf.dVb;
        qVar.Qq();
    }
}
