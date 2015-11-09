package com.baidu.tieba.imMessageCenter.im.stranger;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ StrangerListActivity bOR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(StrangerListActivity strangerListActivity) {
        this.bOR = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        i iVar;
        i iVar2;
        StrangerListModel strangerListModel;
        StrangerListModel strangerListModel2;
        i iVar3;
        StrangerListModel strangerListModel3;
        iVar = this.bOR.bOL;
        if (iVar != null) {
            iVar2 = this.bOR.bOL;
            if (iVar2.aab() != null) {
                strangerListModel = this.bOR.bOM;
                if (strangerListModel != null) {
                    strangerListModel2 = this.bOR.bOM;
                    if (strangerListModel2.getData().size() == 0) {
                        this.bOR.finish();
                    }
                    iVar3 = this.bOR.bOL;
                    StrangerListAdapter aab = iVar3.aab();
                    strangerListModel3 = this.bOR.bOM;
                    aab.setData(strangerListModel3.getData());
                }
            }
        }
    }
}
