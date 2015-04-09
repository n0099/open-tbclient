package com.baidu.tieba.recommendfrs;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.PbListView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.recommendfrs.a.e {
    final /* synthetic */ b bXW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.bXW = bVar;
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
        bdListView = this.bXW.aBF;
        bdListView.mW();
        this.bXW.aId = false;
        if (cVar != null) {
            this.bXW.mHasMore = cVar.getHasMore();
            z3 = this.bXW.mHasMore;
            if (!z3) {
                bdListView2 = this.bXW.aBF;
                bdListView2.setNextPage(null);
            } else {
                pbListView = this.bXW.aLV;
                if (pbListView.getView().getParent() == null) {
                    bdListView3 = this.bXW.aBF;
                    pbListView2 = this.bXW.aLV;
                    bdListView3.setNextPage(pbListView2);
                }
            }
            if (!z) {
                this.bXW.aBM = true;
            } else {
                this.bXW.aBN = true;
            }
            a = this.bXW.a(z2, cVar);
            if (z2) {
                bVar2 = this.bXW.bXT;
                list = bVar2.Ca();
                list.addAll(a);
            } else {
                this.bXW.aX(cVar.afU());
                list = a;
            }
            bVar = this.bXW.bXT;
            bVar.r(list);
        }
    }

    @Override // com.baidu.tieba.recommendfrs.a.e
    public void Gb() {
        BdListView bdListView;
        this.bXW.aId = false;
        bdListView = this.bXW.aBF;
        bdListView.mW();
    }
}
