package com.baidu.tieba.imMessageCenter.im.stranger;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ StrangerListActivity cmw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(StrangerListActivity strangerListActivity) {
        this.cmw = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        i iVar;
        i iVar2;
        StrangerListModel strangerListModel;
        StrangerListModel strangerListModel2;
        i iVar3;
        StrangerListModel strangerListModel3;
        iVar = this.cmw.cmq;
        if (iVar != null) {
            iVar2 = this.cmw.cmq;
            if (iVar2.ahA() != null) {
                strangerListModel = this.cmw.cmr;
                if (strangerListModel != null) {
                    strangerListModel2 = this.cmw.cmr;
                    if (strangerListModel2.getData().size() == 0) {
                        this.cmw.finish();
                    }
                    iVar3 = this.cmw.cmq;
                    StrangerListAdapter ahA = iVar3.ahA();
                    strangerListModel3 = this.cmw.cmr;
                    ahA.setData(strangerListModel3.getData());
                }
            }
        }
    }
}
