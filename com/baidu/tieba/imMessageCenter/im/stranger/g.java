package com.baidu.tieba.imMessageCenter.im.stranger;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ StrangerListActivity bOw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(StrangerListActivity strangerListActivity) {
        this.bOw = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        i iVar;
        i iVar2;
        StrangerListModel strangerListModel;
        StrangerListModel strangerListModel2;
        i iVar3;
        StrangerListModel strangerListModel3;
        iVar = this.bOw.bOq;
        if (iVar != null) {
            iVar2 = this.bOw.bOq;
            if (iVar2.ZG() != null) {
                strangerListModel = this.bOw.bOr;
                if (strangerListModel != null) {
                    strangerListModel2 = this.bOw.bOr;
                    if (strangerListModel2.getData().size() == 0) {
                        this.bOw.finish();
                    }
                    iVar3 = this.bOw.bOq;
                    StrangerListAdapter ZG = iVar3.ZG();
                    strangerListModel3 = this.bOw.bOr;
                    ZG.setData(strangerListModel3.getData());
                }
            }
        }
    }
}
