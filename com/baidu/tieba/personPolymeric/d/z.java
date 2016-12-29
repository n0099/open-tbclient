package com.baidu.tieba.personPolymeric.d;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements BdListView.e {
    final /* synthetic */ x evO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.evO = xVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void kx() {
        PbListView pbListView;
        com.baidu.tieba.model.a aVar;
        com.baidu.tieba.model.a aVar2;
        PbListView pbListView2;
        com.baidu.tieba.model.a aVar3;
        pbListView = this.evO.aMJ;
        if (pbListView != null) {
            aVar = this.evO.fuG;
            if (aVar != null) {
                aVar2 = this.evO.fuG;
                if (aVar2.aEa()) {
                    pbListView2 = this.evO.aMJ;
                    pbListView2.wp();
                    aVar3 = this.evO.fuG;
                    aVar3.Tj();
                }
            }
        }
    }
}
