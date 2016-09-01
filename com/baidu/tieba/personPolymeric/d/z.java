package com.baidu.tieba.personPolymeric.d;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements BdListView.e {
    final /* synthetic */ x eJO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.eJO = xVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void kx() {
        PbListView pbListView;
        com.baidu.tieba.model.a aVar;
        com.baidu.tieba.model.a aVar2;
        PbListView pbListView2;
        com.baidu.tieba.model.a aVar3;
        pbListView = this.eJO.bvo;
        if (pbListView != null) {
            aVar = this.eJO.fWo;
            if (aVar != null) {
                aVar2 = this.eJO.fWo;
                if (aVar2.hasMoreData()) {
                    pbListView2 = this.eJO.bvo;
                    pbListView2.wl();
                    aVar3 = this.eJO.fWo;
                    aVar3.Rt();
                }
            }
        }
    }
}
