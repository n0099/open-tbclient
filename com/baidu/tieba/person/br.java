package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements BdListView.e {
    final /* synthetic */ PersonListActivity csj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(PersonListActivity personListActivity) {
        this.csj = personListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        bs bsVar;
        bsVar = this.csj.cse;
        if (!bsVar.isHasMore()) {
            return;
        }
        this.csj.ajj();
    }
}
