package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements BdListView.f {
    final /* synthetic */ w ddU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.ddU = wVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void t(BdListView bdListView) {
        if (this.ddU instanceof j) {
            this.ddU.ddD.atO().LL();
        } else {
            this.ddU.ddD.atN().LL();
        }
    }
}
