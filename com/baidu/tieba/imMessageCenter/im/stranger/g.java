package com.baidu.tieba.imMessageCenter.im.stranger;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ StrangerListActivity bLb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(StrangerListActivity strangerListActivity) {
        this.bLb = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        i iVar;
        i iVar2;
        StrangerListModel strangerListModel;
        StrangerListModel strangerListModel2;
        i iVar3;
        StrangerListModel strangerListModel3;
        iVar = this.bLb.bKV;
        if (iVar != null) {
            iVar2 = this.bLb.bKV;
            if (iVar2.YW() != null) {
                strangerListModel = this.bLb.bKW;
                if (strangerListModel != null) {
                    strangerListModel2 = this.bLb.bKW;
                    if (strangerListModel2.getData().size() == 0) {
                        this.bLb.finish();
                    }
                    iVar3 = this.bLb.bKV;
                    StrangerListAdapter YW = iVar3.YW();
                    strangerListModel3 = this.bLb.bKW;
                    YW.setData(strangerListModel3.getData());
                }
            }
        }
    }
}
