package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements com.baidu.adp.widget.ListView.x {
    final /* synthetic */ PersonListActivity bQz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(PersonListActivity personListActivity) {
        this.bQz = personListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        bh bhVar;
        bhVar = this.bQz.bQu;
        if (!bhVar.isHasMore()) {
            return;
        }
        this.bQz.adc();
    }
}
