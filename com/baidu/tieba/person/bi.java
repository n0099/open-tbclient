package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements com.baidu.adp.widget.ListView.ab {
    final /* synthetic */ PersonListActivity bIr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(PersonListActivity personListActivity) {
        this.bIr = personListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.ab
    public void onScrollToBottom() {
        bj bjVar;
        bjVar = this.bIr.bIm;
        if (!bjVar.isHasMore()) {
            return;
        }
        this.bIr.aaT();
    }
}
