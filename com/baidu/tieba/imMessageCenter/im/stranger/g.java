package com.baidu.tieba.imMessageCenter.im.stranger;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ StrangerListActivity chU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(StrangerListActivity strangerListActivity) {
        this.chU = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        i iVar;
        i iVar2;
        StrangerListModel strangerListModel;
        StrangerListModel strangerListModel2;
        i iVar3;
        StrangerListModel strangerListModel3;
        iVar = this.chU.chO;
        if (iVar != null) {
            iVar2 = this.chU.chO;
            if (iVar2.aeq() != null) {
                strangerListModel = this.chU.chP;
                if (strangerListModel != null) {
                    strangerListModel2 = this.chU.chP;
                    if (strangerListModel2.getData().size() == 0) {
                        this.chU.finish();
                    }
                    iVar3 = this.chU.chO;
                    StrangerListAdapter aeq = iVar3.aeq();
                    strangerListModel3 = this.chU.chP;
                    aeq.setData(strangerListModel3.getData());
                }
            }
        }
    }
}
