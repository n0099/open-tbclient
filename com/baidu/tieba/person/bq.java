package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements BdListView.e {
    final /* synthetic */ PersonListActivity ckY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(PersonListActivity personListActivity) {
        this.ckY = personListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        br brVar;
        brVar = this.ckY.ckT;
        if (!brVar.isHasMore()) {
            return;
        }
        this.ckY.agH();
    }
}
