package com.baidu.tieba.imMessageCenter.im.stranger;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ StrangerListActivity dtr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(StrangerListActivity strangerListActivity) {
        this.dtr = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        i iVar;
        i iVar2;
        StrangerListModel strangerListModel;
        StrangerListModel strangerListModel2;
        i iVar3;
        StrangerListModel strangerListModel3;
        iVar = this.dtr.dtl;
        if (iVar != null) {
            iVar2 = this.dtr.dtl;
            if (iVar2.azn() != null) {
                strangerListModel = this.dtr.dtm;
                if (strangerListModel != null) {
                    strangerListModel2 = this.dtr.dtm;
                    if (strangerListModel2.getData().size() == 0) {
                        this.dtr.finish();
                    }
                    iVar3 = this.dtr.dtl;
                    StrangerListAdapter azn = iVar3.azn();
                    strangerListModel3 = this.dtr.dtm;
                    azn.setData(strangerListModel3.getData());
                }
            }
        }
    }
}
