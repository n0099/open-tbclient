package com.baidu.tieba.imMessageCenter.im.stranger;
/* loaded from: classes2.dex */
class g implements com.baidu.tieba.im.chat.a.a {
    final /* synthetic */ StrangerListActivity dlM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(StrangerListActivity strangerListActivity) {
        this.dlM = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.a.a
    public void onComplete() {
        i iVar;
        i iVar2;
        StrangerListModel strangerListModel;
        StrangerListModel strangerListModel2;
        i iVar3;
        StrangerListModel strangerListModel3;
        iVar = this.dlM.dlG;
        if (iVar != null) {
            iVar2 = this.dlM.dlG;
            if (iVar2.atS() != null) {
                strangerListModel = this.dlM.dlH;
                if (strangerListModel != null) {
                    strangerListModel2 = this.dlM.dlH;
                    if (strangerListModel2.getData().size() == 0) {
                        this.dlM.finish();
                    }
                    iVar3 = this.dlM.dlG;
                    StrangerListAdapter atS = iVar3.atS();
                    strangerListModel3 = this.dlM.dlH;
                    atS.setData(strangerListModel3.getData());
                }
            }
        }
    }
}
