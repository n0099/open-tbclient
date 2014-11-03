package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements com.baidu.adp.widget.ListView.aa {
    final /* synthetic */ PersonListActivity bDh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(PersonListActivity personListActivity) {
        this.bDh = personListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.aa
    public void hQ() {
        bs bsVar;
        bsVar = this.bDh.bDc;
        if (!bsVar.isHasMore()) {
            return;
        }
        this.bDh.aac();
    }
}
