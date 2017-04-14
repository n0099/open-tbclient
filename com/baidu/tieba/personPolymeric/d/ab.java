package com.baidu.tieba.personPolymeric.d;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements BdListView.e {
    final /* synthetic */ z eHj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar) {
        this.eHj = zVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void ln() {
        PbListView pbListView;
        com.baidu.tieba.model.a aVar;
        com.baidu.tieba.model.a aVar2;
        PbListView pbListView2;
        com.baidu.tieba.model.a aVar3;
        pbListView = this.eHj.aRM;
        if (pbListView != null) {
            aVar = this.eHj.fJL;
            if (aVar != null) {
                aVar2 = this.eHj.fJL;
                if (aVar2.QP()) {
                    pbListView2 = this.eHj.aRM;
                    pbListView2.xd();
                    aVar3 = this.eHj.fJL;
                    aVar3.Oc();
                }
            }
        }
    }
}
