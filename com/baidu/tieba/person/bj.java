package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements com.baidu.adp.widget.ListView.ab {
    final /* synthetic */ PersonListActivity bGG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(PersonListActivity personListActivity) {
        this.bGG = personListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.ab
    public void onScrollToBottom() {
        bk bkVar;
        bkVar = this.bGG.bGB;
        if (!bkVar.isHasMore()) {
            return;
        }
        this.bGG.aat();
    }
}
