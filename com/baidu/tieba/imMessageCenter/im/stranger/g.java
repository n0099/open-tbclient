package com.baidu.tieba.imMessageCenter.im.stranger;
/* loaded from: classes2.dex */
class g implements com.baidu.tieba.im.chat.a.a {
    final /* synthetic */ StrangerListActivity dtI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(StrangerListActivity strangerListActivity) {
        this.dtI = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.a.a
    public void onComplete() {
        i iVar;
        i iVar2;
        StrangerListModel strangerListModel;
        StrangerListModel strangerListModel2;
        i iVar3;
        StrangerListModel strangerListModel3;
        iVar = this.dtI.dtC;
        if (iVar != null) {
            iVar2 = this.dtI.dtC;
            if (iVar2.axA() != null) {
                strangerListModel = this.dtI.dtD;
                if (strangerListModel != null) {
                    strangerListModel2 = this.dtI.dtD;
                    if (strangerListModel2.getData().size() == 0) {
                        this.dtI.finish();
                    }
                    iVar3 = this.dtI.dtC;
                    StrangerListAdapter axA = iVar3.axA();
                    strangerListModel3 = this.dtI.dtD;
                    axA.setData(strangerListModel3.getData());
                }
            }
        }
    }
}
