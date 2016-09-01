package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements BdListView.f {
    final /* synthetic */ w dsw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.dsw = wVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void t(BdListView bdListView) {
        if (this.dsw instanceof j) {
            this.dsw.dsf.azn().Op();
        } else {
            this.dsw.dsf.azm().Op();
        }
    }
}
