package com.baidu.tieba.recommendfrs;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements BdListView.e {
    final /* synthetic */ f dXY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(f fVar) {
        this.dXY = fVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void jA() {
        PbListView pbListView;
        r rVar;
        PbListView pbListView2;
        PbListView pbListView3;
        TbPageContext tbPageContext;
        pbListView = this.dXY.bkd;
        if (pbListView != null) {
            pbListView2 = this.dXY.bkd;
            pbListView2.vg();
            pbListView3 = this.dXY.bkd;
            tbPageContext = this.dXY.pageContext;
            pbListView3.cT(com.baidu.adp.lib.util.k.c(tbPageContext.getPageActivity(), t.e.ds110));
        }
        rVar = this.dXY.dXT;
        rVar.Pn();
    }
}
