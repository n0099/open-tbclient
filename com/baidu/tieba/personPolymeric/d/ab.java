package com.baidu.tieba.personPolymeric.d;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements BdListView.e {
    final /* synthetic */ z eJz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar) {
        this.eJz = zVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void lo() {
        PbListView pbListView;
        com.baidu.tieba.model.a aVar;
        com.baidu.tieba.model.a aVar2;
        PbListView pbListView2;
        com.baidu.tieba.model.a aVar3;
        pbListView = this.eJz.aRO;
        if (pbListView != null) {
            aVar = this.eJz.fMh;
            if (aVar != null) {
                aVar2 = this.eJz.fMh;
                if (aVar2.RR()) {
                    pbListView2 = this.eJz.aRO;
                    pbListView2.xd();
                    aVar3 = this.eJz.fMh;
                    aVar3.Ol();
                }
            }
        }
    }
}
