package com.baidu.tieba.imMessageCenter.im.stranger;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ StrangerListActivity dyW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(StrangerListActivity strangerListActivity) {
        this.dyW = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        i iVar;
        i iVar2;
        StrangerListModel strangerListModel;
        StrangerListModel strangerListModel2;
        i iVar3;
        StrangerListModel strangerListModel3;
        iVar = this.dyW.dyQ;
        if (iVar != null) {
            iVar2 = this.dyW.dyQ;
            if (iVar2.aBk() != null) {
                strangerListModel = this.dyW.dyR;
                if (strangerListModel != null) {
                    strangerListModel2 = this.dyW.dyR;
                    if (strangerListModel2.getData().size() == 0) {
                        this.dyW.finish();
                    }
                    iVar3 = this.dyW.dyQ;
                    StrangerListAdapter aBk = iVar3.aBk();
                    strangerListModel3 = this.dyW.dyR;
                    aBk.setData(strangerListModel3.getData());
                }
            }
        }
    }
}
