package com.baidu.tieba.imMessageCenter.im.stranger;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ StrangerListActivity ddq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(StrangerListActivity strangerListActivity) {
        this.ddq = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        i iVar;
        i iVar2;
        StrangerListModel strangerListModel;
        StrangerListModel strangerListModel2;
        i iVar3;
        StrangerListModel strangerListModel3;
        iVar = this.ddq.ddk;
        if (iVar != null) {
            iVar2 = this.ddq.ddk;
            if (iVar2.atp() != null) {
                strangerListModel = this.ddq.ddl;
                if (strangerListModel != null) {
                    strangerListModel2 = this.ddq.ddl;
                    if (strangerListModel2.getData().size() == 0) {
                        this.ddq.finish();
                    }
                    iVar3 = this.ddq.ddk;
                    StrangerListAdapter atp = iVar3.atp();
                    strangerListModel3 = this.ddq.ddl;
                    atp.setData(strangerListModel3.getData());
                }
            }
        }
    }
}
