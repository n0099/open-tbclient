package com.baidu.tieba.pb.history;
/* loaded from: classes.dex */
class c implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ b bum;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.bum = bVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PbHistoryActivity pbHistoryActivity;
        f fVar;
        pbHistoryActivity = this.bum.bul;
        fVar = pbHistoryActivity.buk;
        fVar.tC();
        aVar.dismiss();
    }
}
