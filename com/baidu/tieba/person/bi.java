package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements com.baidu.adp.widget.ListView.ab {
    final /* synthetic */ PersonListActivity bIs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(PersonListActivity personListActivity) {
        this.bIs = personListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.ab
    public void onScrollToBottom() {
        bj bjVar;
        bjVar = this.bIs.bIn;
        if (!bjVar.isHasMore()) {
            return;
        }
        this.bIs.aaY();
    }
}
