package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements BdListView.f {
    final /* synthetic */ w cxy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.cxy = wVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void s(BdListView bdListView) {
        if (this.cxy instanceof j) {
            this.cxy.cxj.alr().Md();
        } else {
            this.cxy.cxj.alq().Md();
        }
    }
}
