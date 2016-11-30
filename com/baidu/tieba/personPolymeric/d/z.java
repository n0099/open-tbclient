package com.baidu.tieba.personPolymeric.d;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements BdListView.e {
    final /* synthetic */ x eSp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.eSp = xVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void kx() {
        PbListView pbListView;
        com.baidu.tieba.model.a aVar;
        com.baidu.tieba.model.a aVar2;
        PbListView pbListView2;
        com.baidu.tieba.model.a aVar3;
        pbListView = this.eSp.aNs;
        if (pbListView != null) {
            aVar = this.eSp.gfO;
            if (aVar != null) {
                aVar2 = this.eSp.gfO;
                if (aVar2.hasMoreData()) {
                    pbListView2 = this.eSp.aNs;
                    pbListView2.wF();
                    aVar3 = this.eSp.gfO;
                    aVar3.SN();
                }
            }
        }
    }
}
