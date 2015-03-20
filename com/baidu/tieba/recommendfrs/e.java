package com.baidu.tieba.recommendfrs;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.PbListView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.recommendfrs.a.e {
    final /* synthetic */ b bXH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.bXH = bVar;
    }

    @Override // com.baidu.tieba.recommendfrs.a.e
    public void a(boolean z, com.baidu.tieba.recommendfrs.data.c cVar, boolean z2) {
        BdListView bdListView;
        boolean z3;
        BdListView bdListView2;
        List a;
        List list;
        com.baidu.tbadk.mvc.j.b bVar;
        com.baidu.tbadk.mvc.j.b bVar2;
        PbListView pbListView;
        BdListView bdListView3;
        PbListView pbListView2;
        bdListView = this.bXH.aBx;
        bdListView.mW();
        this.bXH.aHV = false;
        if (cVar != null) {
            this.bXH.mHasMore = cVar.getHasMore();
            z3 = this.bXH.mHasMore;
            if (!z3) {
                bdListView2 = this.bXH.aBx;
                bdListView2.setNextPage(null);
            } else {
                pbListView = this.bXH.bXC;
                if (pbListView.getView().getParent() == null) {
                    bdListView3 = this.bXH.aBx;
                    pbListView2 = this.bXH.bXC;
                    bdListView3.setNextPage(pbListView2);
                }
            }
            if (!z) {
                this.bXH.aBE = true;
            } else {
                this.bXH.aBF = true;
            }
            a = this.bXH.a(z2, cVar);
            if (z2) {
                bVar2 = this.bXH.bXE;
                list = bVar2.BU();
                list.addAll(a);
            } else {
                this.bXH.aU(cVar.afF());
                list = a;
            }
            bVar = this.bXH.bXE;
            bVar.r(list);
        }
    }

    @Override // com.baidu.tieba.recommendfrs.a.e
    public void FV() {
        BdListView bdListView;
        this.bXH.aHV = false;
        bdListView = this.bXH.aBx;
        bdListView.mW();
    }
}
