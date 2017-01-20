package com.baidu.tieba.imMessageCenter.im.stranger;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.im.chat.a.a {
    final /* synthetic */ StrangerListActivity djd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(StrangerListActivity strangerListActivity) {
        this.djd = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.a.a
    public void onComplete() {
        i iVar;
        i iVar2;
        StrangerListModel strangerListModel;
        StrangerListModel strangerListModel2;
        i iVar3;
        StrangerListModel strangerListModel3;
        iVar = this.djd.diX;
        if (iVar != null) {
            iVar2 = this.djd.diX;
            if (iVar2.avM() != null) {
                strangerListModel = this.djd.diY;
                if (strangerListModel != null) {
                    strangerListModel2 = this.djd.diY;
                    if (strangerListModel2.getData().size() == 0) {
                        this.djd.finish();
                    }
                    iVar3 = this.djd.diX;
                    StrangerListAdapter avM = iVar3.avM();
                    strangerListModel3 = this.djd.diY;
                    avM.setData(strangerListModel3.getData());
                }
            }
        }
    }
}
