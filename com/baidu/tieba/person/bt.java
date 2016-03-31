package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements BdListView.e {
    final /* synthetic */ PersonListActivity dtT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(PersonListActivity personListActivity) {
        this.dtT = personListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nm() {
        bu buVar;
        buVar = this.dtT.dtO;
        if (!buVar.isHasMore()) {
            return;
        }
        this.dtT.aBw();
    }
}
