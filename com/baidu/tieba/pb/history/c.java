package com.baidu.tieba.pb.history;
/* loaded from: classes.dex */
class c implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ b buA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.buA = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PbHistoryActivity pbHistoryActivity;
        f fVar;
        pbHistoryActivity = this.buA.buz;
        fVar = pbHistoryActivity.buy;
        fVar.tE();
        aVar.dismiss();
    }
}
