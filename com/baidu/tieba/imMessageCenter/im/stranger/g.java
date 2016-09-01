package com.baidu.tieba.imMessageCenter.im.stranger;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ StrangerListActivity drU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(StrangerListActivity strangerListActivity) {
        this.drU = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        i iVar;
        i iVar2;
        StrangerListModel strangerListModel;
        StrangerListModel strangerListModel2;
        i iVar3;
        StrangerListModel strangerListModel3;
        iVar = this.drU.drO;
        if (iVar != null) {
            iVar2 = this.drU.drO;
            if (iVar2.ayP() != null) {
                strangerListModel = this.drU.drP;
                if (strangerListModel != null) {
                    strangerListModel2 = this.drU.drP;
                    if (strangerListModel2.getData().size() == 0) {
                        this.drU.finish();
                    }
                    iVar3 = this.drU.drO;
                    StrangerListAdapter ayP = iVar3.ayP();
                    strangerListModel3 = this.drU.drP;
                    ayP.setData(strangerListModel3.getData());
                }
            }
        }
    }
}
