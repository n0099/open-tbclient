package com.baidu.tieba.myCollection.history;
/* loaded from: classes.dex */
class d implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ c bEB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bEB = cVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PbHistoryActivity pbHistoryActivity;
        com.baidu.tieba.myCollection.baseHistory.a aVar2;
        pbHistoryActivity = this.bEB.bEA;
        aVar2 = pbHistoryActivity.bEz;
        aVar2.AM();
        aVar.dismiss();
    }
}
