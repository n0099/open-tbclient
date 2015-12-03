package com.baidu.tieba.person;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements BdListView.e {
    final /* synthetic */ PersonListActivity cLD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(PersonListActivity personListActivity) {
        this.cLD = personListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        bt btVar;
        btVar = this.cLD.cLy;
        if (!btVar.isHasMore()) {
            return;
        }
        this.cLD.anM();
    }
}
