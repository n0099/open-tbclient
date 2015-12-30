package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements BdListView.e {
    final /* synthetic */ PersonListActivity cPT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(PersonListActivity personListActivity) {
        this.cPT = personListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        bt btVar;
        btVar = this.cPT.cPO;
        if (!btVar.isHasMore()) {
            return;
        }
        this.cPT.aoX();
    }
}
