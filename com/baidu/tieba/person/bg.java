package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements com.baidu.adp.widget.ListView.x {
    final /* synthetic */ PersonListActivity bQP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(PersonListActivity personListActivity) {
        this.bQP = personListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        bh bhVar;
        bhVar = this.bQP.bQK;
        if (!bhVar.isHasMore()) {
            return;
        }
        this.bQP.adr();
    }
}
