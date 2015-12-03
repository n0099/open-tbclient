package com.baidu.tieba.imMessageCenter.im.stranger;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ StrangerListActivity cdU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(StrangerListActivity strangerListActivity) {
        this.cdU = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        i iVar;
        i iVar2;
        StrangerListModel strangerListModel;
        StrangerListModel strangerListModel2;
        i iVar3;
        StrangerListModel strangerListModel3;
        iVar = this.cdU.cdO;
        if (iVar != null) {
            iVar2 = this.cdU.cdO;
            if (iVar2.adh() != null) {
                strangerListModel = this.cdU.cdP;
                if (strangerListModel != null) {
                    strangerListModel2 = this.cdU.cdP;
                    if (strangerListModel2.getData().size() == 0) {
                        this.cdU.finish();
                    }
                    iVar3 = this.cdU.cdO;
                    StrangerListAdapter adh = iVar3.adh();
                    strangerListModel3 = this.cdU.cdP;
                    adh.setData(strangerListModel3.getData());
                }
            }
        }
    }
}
