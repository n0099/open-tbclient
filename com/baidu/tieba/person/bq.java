package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements BdListView.e {
    final /* synthetic */ PersonListActivity ckd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(PersonListActivity personListActivity) {
        this.ckd = personListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        br brVar;
        brVar = this.ckd.cjY;
        if (!brVar.isHasMore()) {
            return;
        }
        this.ckd.agr();
    }
}
