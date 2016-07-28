package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements BdListView.f {
    final /* synthetic */ w dgQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.dgQ = wVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.f
    public void t(BdListView bdListView) {
        if (this.dgQ instanceof j) {
            this.dgQ.dgz.auA().LK();
        } else {
            this.dgQ.dgz.auz().LK();
        }
    }
}
