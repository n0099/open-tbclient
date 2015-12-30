package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements BdListView.f {
    final /* synthetic */ w ciw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.ciw = wVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void s(BdListView bdListView) {
        if (this.ciw instanceof j) {
            this.ciw.cih.aeO().IR();
        } else {
            this.ciw.cih.aeN().IR();
        }
    }
}
