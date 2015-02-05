package com.baidu.tieba.im.stranger;
/* loaded from: classes.dex */
class d implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ StrangerListActivity bpq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(StrangerListActivity strangerListActivity) {
        this.bpq = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        f fVar;
        f fVar2;
        StrangerListModel strangerListModel;
        StrangerListModel strangerListModel2;
        f fVar3;
        StrangerListModel strangerListModel3;
        fVar = this.bpq.bpk;
        if (fVar != null) {
            fVar2 = this.bpq.bpk;
            if (fVar2.Ts() != null) {
                strangerListModel = this.bpq.bpl;
                if (strangerListModel != null) {
                    strangerListModel2 = this.bpq.bpl;
                    if (strangerListModel2.getData().size() == 0) {
                        this.bpq.finish();
                    }
                    fVar3 = this.bpq.bpk;
                    StrangerListAdapter Ts = fVar3.Ts();
                    strangerListModel3 = this.bpq.bpl;
                    Ts.setData(strangerListModel3.getData());
                }
            }
        }
    }
}
