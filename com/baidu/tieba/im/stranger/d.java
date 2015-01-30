package com.baidu.tieba.im.stranger;
/* loaded from: classes.dex */
class d implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ StrangerListActivity bpr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(StrangerListActivity strangerListActivity) {
        this.bpr = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        f fVar;
        f fVar2;
        StrangerListModel strangerListModel;
        StrangerListModel strangerListModel2;
        f fVar3;
        StrangerListModel strangerListModel3;
        fVar = this.bpr.bpl;
        if (fVar != null) {
            fVar2 = this.bpr.bpl;
            if (fVar2.Tx() != null) {
                strangerListModel = this.bpr.bpm;
                if (strangerListModel != null) {
                    strangerListModel2 = this.bpr.bpm;
                    if (strangerListModel2.getData().size() == 0) {
                        this.bpr.finish();
                    }
                    fVar3 = this.bpr.bpl;
                    StrangerListAdapter Tx = fVar3.Tx();
                    strangerListModel3 = this.bpr.bpm;
                    Tx.setData(strangerListModel3.getData());
                }
            }
        }
    }
}
