package com.baidu.tieba.pb.history;
/* loaded from: classes.dex */
class d implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PbHistoryActivity pbHistoryActivity;
        RequestPbHistoryWriteMessage requestPbHistoryWriteMessage = new RequestPbHistoryWriteMessage();
        requestPbHistoryWriteMessage.setClear(true);
        pbHistoryActivity = this.a.a;
        pbHistoryActivity.sendMessage(requestPbHistoryWriteMessage);
        aVar.d();
    }
}
