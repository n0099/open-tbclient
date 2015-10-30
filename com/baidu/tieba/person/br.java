package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements BdListView.e {
    final /* synthetic */ PersonListActivity cqN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(PersonListActivity personListActivity) {
        this.cqN = personListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        bs bsVar;
        bsVar = this.cqN.cqI;
        if (!bsVar.isHasMore()) {
            return;
        }
        this.cqN.aiD();
    }
}
