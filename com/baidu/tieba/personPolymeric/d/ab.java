package com.baidu.tieba.personPolymeric.d;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements BdListView.e {
    final /* synthetic */ z eJo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar) {
        this.eJo = zVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void lj() {
        PbListView pbListView;
        com.baidu.tieba.model.a aVar;
        com.baidu.tieba.model.a aVar2;
        PbListView pbListView2;
        com.baidu.tieba.model.a aVar3;
        pbListView = this.eJo.aRw;
        if (pbListView != null) {
            aVar = this.eJo.fIc;
            if (aVar != null) {
                aVar2 = this.eJo.fIc;
                if (aVar2.Qr()) {
                    pbListView2 = this.eJo.aRw;
                    pbListView2.wH();
                    aVar3 = this.eJo.fIc;
                    aVar3.NE();
                }
            }
        }
    }
}
