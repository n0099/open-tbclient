package com.baidu.tieba.imMessageCenter.im.stranger;
/* loaded from: classes.dex */
class h implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ StrangerListActivity btU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(StrangerListActivity strangerListActivity) {
        this.btU = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        j jVar;
        j jVar2;
        StrangerListModel strangerListModel;
        StrangerListModel strangerListModel2;
        j jVar3;
        StrangerListModel strangerListModel3;
        jVar = this.btU.btO;
        if (jVar != null) {
            jVar2 = this.btU.btO;
            if (jVar2.VV() != null) {
                strangerListModel = this.btU.btP;
                if (strangerListModel != null) {
                    strangerListModel2 = this.btU.btP;
                    if (strangerListModel2.getData().size() == 0) {
                        this.btU.finish();
                    }
                    jVar3 = this.btU.btO;
                    StrangerListAdapter VV = jVar3.VV();
                    strangerListModel3 = this.btU.btP;
                    VV.setData(strangerListModel3.getData());
                }
            }
        }
    }
}
