package com.baidu.tieba.person.post;
/* loaded from: classes.dex */
class x implements com.baidu.adp.widget.ListView.g {
    final /* synthetic */ t bHQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar) {
        this.bHQ = tVar;
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        q qVar;
        q qVar2;
        qVar = this.bHQ.bHN;
        if (qVar != null) {
            qVar2 = this.bHQ.bHN;
            qVar2.ed(true);
        }
    }
}
