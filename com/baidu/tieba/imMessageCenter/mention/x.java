package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements BdListView.f {
    final /* synthetic */ w dtT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.dtT = wVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void t(BdListView bdListView) {
        if (this.dtT instanceof j) {
            this.dtT.dtC.azL().OR();
        } else {
            this.dtT.dtC.azK().OR();
        }
    }
}
