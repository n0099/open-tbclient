package com.baidu.tieba.person.post;
/* loaded from: classes.dex */
class w implements com.baidu.adp.widget.ListView.g {
    final /* synthetic */ s bJC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(s sVar) {
        this.bJC = sVar;
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        p pVar;
        p pVar2;
        pVar = this.bJC.bJz;
        if (pVar != null) {
            pVar2 = this.bJC.bJz;
            pVar2.ej(true);
        }
    }
}
