package com.baidu.tieba.imMessageCenter.im.stranger;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ StrangerListActivity cwY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(StrangerListActivity strangerListActivity) {
        this.cwY = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        i iVar;
        i iVar2;
        StrangerListModel strangerListModel;
        StrangerListModel strangerListModel2;
        i iVar3;
        StrangerListModel strangerListModel3;
        iVar = this.cwY.cwS;
        if (iVar != null) {
            iVar2 = this.cwY.cwS;
            if (iVar2.akU() != null) {
                strangerListModel = this.cwY.cwT;
                if (strangerListModel != null) {
                    strangerListModel2 = this.cwY.cwT;
                    if (strangerListModel2.getData().size() == 0) {
                        this.cwY.finish();
                    }
                    iVar3 = this.cwY.cwS;
                    StrangerListAdapter akU = iVar3.akU();
                    strangerListModel3 = this.cwY.cwT;
                    akU.setData(strangerListModel3.getData());
                }
            }
        }
    }
}
