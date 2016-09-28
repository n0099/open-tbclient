package com.baidu.tieba.personPolymeric.d;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements BdListView.e {
    final /* synthetic */ x eLR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.eLR = xVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void kx() {
        PbListView pbListView;
        com.baidu.tieba.model.a aVar;
        com.baidu.tieba.model.a aVar2;
        PbListView pbListView2;
        com.baidu.tieba.model.a aVar3;
        pbListView = this.eLR.aMn;
        if (pbListView != null) {
            aVar = this.eLR.fYt;
            if (aVar != null) {
                aVar2 = this.eLR.fYt;
                if (aVar2.hasMoreData()) {
                    pbListView2 = this.eLR.aMn;
                    pbListView2.wB();
                    aVar3 = this.eLR.fYt;
                    aVar3.RL();
                }
            }
        }
    }
}
