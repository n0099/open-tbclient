package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements BdListView.e {
    final /* synthetic */ PersonListActivity cZq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(PersonListActivity personListActivity) {
        this.cZq = personListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nv() {
        bu buVar;
        buVar = this.cZq.cZl;
        if (!buVar.isHasMore()) {
            return;
        }
        this.cZq.atQ();
    }
}
