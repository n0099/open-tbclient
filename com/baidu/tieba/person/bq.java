package com.baidu.tieba.person;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements com.baidu.adp.widget.ListView.aa {
    final /* synthetic */ PersonListActivity bCT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(PersonListActivity personListActivity) {
        this.bCT = personListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.aa
    public void hQ() {
        br brVar;
        brVar = this.bCT.bCO;
        if (!brVar.isHasMore()) {
            return;
        }
        this.bCT.aaa();
    }
}
