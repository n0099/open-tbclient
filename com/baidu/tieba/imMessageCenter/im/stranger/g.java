package com.baidu.tieba.imMessageCenter.im.stranger;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.im.chat.a.a {
    final /* synthetic */ StrangerListActivity dbR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(StrangerListActivity strangerListActivity) {
        this.dbR = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.a.a
    public void onComplete() {
        i iVar;
        i iVar2;
        StrangerListModel strangerListModel;
        StrangerListModel strangerListModel2;
        i iVar3;
        StrangerListModel strangerListModel3;
        iVar = this.dbR.dbL;
        if (iVar != null) {
            iVar2 = this.dbR.dbL;
            if (iVar2.auG() != null) {
                strangerListModel = this.dbR.dbM;
                if (strangerListModel != null) {
                    strangerListModel2 = this.dbR.dbM;
                    if (strangerListModel2.getData().size() == 0) {
                        this.dbR.finish();
                    }
                    iVar3 = this.dbR.dbL;
                    StrangerListAdapter auG = iVar3.auG();
                    strangerListModel3 = this.dbR.dbM;
                    auG.setData(strangerListModel3.getData());
                }
            }
        }
    }
}
