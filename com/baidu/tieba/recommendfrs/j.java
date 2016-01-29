package com.baidu.tieba.recommendfrs;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements BdListView.e {
    final /* synthetic */ f dDl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(f fVar) {
        this.dDl = fVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nv() {
        PbListView pbListView;
        p pVar;
        PbListView pbListView2;
        pbListView = this.dDl.aXw;
        if (pbListView != null) {
            pbListView2 = this.dDl.aXw;
            pbListView2.xb();
        }
        pVar = this.dDl.dDh;
        pVar.OB();
    }
}
