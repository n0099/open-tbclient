package com.baidu.tieba.imMessageCenter.im.stranger;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ StrangerListActivity dgn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(StrangerListActivity strangerListActivity) {
        this.dgn = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        i iVar;
        i iVar2;
        StrangerListModel strangerListModel;
        StrangerListModel strangerListModel2;
        i iVar3;
        StrangerListModel strangerListModel3;
        iVar = this.dgn.dgh;
        if (iVar != null) {
            iVar2 = this.dgn.dgh;
            if (iVar2.aub() != null) {
                strangerListModel = this.dgn.dgi;
                if (strangerListModel != null) {
                    strangerListModel2 = this.dgn.dgi;
                    if (strangerListModel2.getData().size() == 0) {
                        this.dgn.finish();
                    }
                    iVar3 = this.dgn.dgh;
                    StrangerListAdapter aub = iVar3.aub();
                    strangerListModel3 = this.dgn.dgi;
                    aub.setData(strangerListModel3.getData());
                }
            }
        }
    }
}
