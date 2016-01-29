package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements BdListView.f {
    final /* synthetic */ w cmW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.cmW = wVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void s(BdListView bdListView) {
        if (this.cmW instanceof j) {
            this.cmW.cmH.ahX().KJ();
        } else {
            this.cmW.cmH.ahW().KJ();
        }
    }
}
