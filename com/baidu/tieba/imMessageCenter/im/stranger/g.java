package com.baidu.tieba.imMessageCenter.im.stranger;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.im.chat.a.a {
    final /* synthetic */ StrangerListActivity dmm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(StrangerListActivity strangerListActivity) {
        this.dmm = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.a.a
    public void onComplete() {
        i iVar;
        i iVar2;
        StrangerListModel strangerListModel;
        StrangerListModel strangerListModel2;
        i iVar3;
        StrangerListModel strangerListModel3;
        iVar = this.dmm.dmg;
        if (iVar != null) {
            iVar2 = this.dmm.dmg;
            if (iVar2.awc() != null) {
                strangerListModel = this.dmm.dmh;
                if (strangerListModel != null) {
                    strangerListModel2 = this.dmm.dmh;
                    if (strangerListModel2.getData().size() == 0) {
                        this.dmm.finish();
                    }
                    iVar3 = this.dmm.dmg;
                    StrangerListAdapter awc = iVar3.awc();
                    strangerListModel3 = this.dmm.dmh;
                    awc.setData(strangerListModel3.getData());
                }
            }
        }
    }
}
