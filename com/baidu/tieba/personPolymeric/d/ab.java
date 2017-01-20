package com.baidu.tieba.personPolymeric.d;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements BdListView.e {
    final /* synthetic */ z eFM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar) {
        this.eFM = zVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void kp() {
        PbListView pbListView;
        com.baidu.tieba.model.a aVar;
        com.baidu.tieba.model.a aVar2;
        PbListView pbListView2;
        com.baidu.tieba.model.a aVar3;
        pbListView = this.eFM.aLK;
        if (pbListView != null) {
            aVar = this.eFM.fDB;
            if (aVar != null) {
                aVar2 = this.eFM.fDB;
                if (aVar2.Py()) {
                    pbListView2 = this.eFM.aLK;
                    pbListView2.wk();
                    aVar3 = this.eFM.fDB;
                    aVar3.MR();
                }
            }
        }
    }
}
