package com.baidu.tieba.imMessageCenter.im.stranger;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ StrangerListActivity cxV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(StrangerListActivity strangerListActivity) {
        this.cxV = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        i iVar;
        i iVar2;
        StrangerListModel strangerListModel;
        StrangerListModel strangerListModel2;
        i iVar3;
        StrangerListModel strangerListModel3;
        iVar = this.cxV.cxP;
        if (iVar != null) {
            iVar2 = this.cxV.cxP;
            if (iVar2.ala() != null) {
                strangerListModel = this.cxV.cxQ;
                if (strangerListModel != null) {
                    strangerListModel2 = this.cxV.cxQ;
                    if (strangerListModel2.getData().size() == 0) {
                        this.cxV.finish();
                    }
                    iVar3 = this.cxV.cxP;
                    StrangerListAdapter ala = iVar3.ala();
                    strangerListModel3 = this.cxV.cxQ;
                    ala.setData(strangerListModel3.getData());
                }
            }
        }
    }
}
