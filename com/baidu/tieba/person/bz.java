package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz implements com.baidu.adp.widget.ListView.x {
    final /* synthetic */ PersonListActivity bTv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(PersonListActivity personListActivity) {
        this.bTv = personListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        ca caVar;
        caVar = this.bTv.bTq;
        if (!caVar.isHasMore()) {
            return;
        }
        this.bTv.aeA();
    }
}
