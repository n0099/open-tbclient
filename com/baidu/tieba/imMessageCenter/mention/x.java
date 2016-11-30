package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements BdListView.f {
    final /* synthetic */ w dzy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.dzy = wVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void t(BdListView bdListView) {
        if (this.dzy instanceof j) {
            this.dzy.dzh.aBH().PU();
        } else {
            this.dzy.dzh.aBG().PU();
        }
    }
}
