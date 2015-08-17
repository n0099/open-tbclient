package com.baidu.tieba.imMessageCenter.im.stranger;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ StrangerListActivity bKu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(StrangerListActivity strangerListActivity) {
        this.bKu = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        i iVar;
        i iVar2;
        StrangerListModel strangerListModel;
        StrangerListModel strangerListModel2;
        i iVar3;
        StrangerListModel strangerListModel3;
        iVar = this.bKu.bKo;
        if (iVar != null) {
            iVar2 = this.bKu.bKo;
            if (iVar2.YU() != null) {
                strangerListModel = this.bKu.bKp;
                if (strangerListModel != null) {
                    strangerListModel2 = this.bKu.bKp;
                    if (strangerListModel2.getData().size() == 0) {
                        this.bKu.finish();
                    }
                    iVar3 = this.bKu.bKo;
                    StrangerListAdapter YU = iVar3.YU();
                    strangerListModel3 = this.bKu.bKp;
                    YU.setData(strangerListModel3.getData());
                }
            }
        }
    }
}
