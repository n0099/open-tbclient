package com.baidu.tieba.person.post;
/* loaded from: classes.dex */
class w implements com.baidu.adp.widget.ListView.g {
    final /* synthetic */ s bJB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(s sVar) {
        this.bJB = sVar;
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        p pVar;
        p pVar2;
        pVar = this.bJB.bJy;
        if (pVar != null) {
            pVar2 = this.bJB.bJy;
            pVar2.ej(true);
        }
    }
}
