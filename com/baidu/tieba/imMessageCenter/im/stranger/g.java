package com.baidu.tieba.imMessageCenter.im.stranger;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ StrangerListActivity bOl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(StrangerListActivity strangerListActivity) {
        this.bOl = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        i iVar;
        i iVar2;
        StrangerListModel strangerListModel;
        StrangerListModel strangerListModel2;
        i iVar3;
        StrangerListModel strangerListModel3;
        iVar = this.bOl.bOf;
        if (iVar != null) {
            iVar2 = this.bOl.bOf;
            if (iVar2.ZK() != null) {
                strangerListModel = this.bOl.bOg;
                if (strangerListModel != null) {
                    strangerListModel2 = this.bOl.bOg;
                    if (strangerListModel2.getData().size() == 0) {
                        this.bOl.finish();
                    }
                    iVar3 = this.bOl.bOf;
                    StrangerListAdapter ZK = iVar3.ZK();
                    strangerListModel3 = this.bOl.bOg;
                    ZK.setData(strangerListModel3.getData());
                }
            }
        }
    }
}
