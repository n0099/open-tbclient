package com.baidu.tieba.imMessageCenter.im.stranger;
/* loaded from: classes.dex */
class h implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ StrangerListActivity btE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(StrangerListActivity strangerListActivity) {
        this.btE = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        j jVar;
        j jVar2;
        StrangerListModel strangerListModel;
        StrangerListModel strangerListModel2;
        j jVar3;
        StrangerListModel strangerListModel3;
        jVar = this.btE.bty;
        if (jVar != null) {
            jVar2 = this.btE.bty;
            if (jVar2.VI() != null) {
                strangerListModel = this.btE.btz;
                if (strangerListModel != null) {
                    strangerListModel2 = this.btE.btz;
                    if (strangerListModel2.getData().size() == 0) {
                        this.btE.finish();
                    }
                    jVar3 = this.btE.bty;
                    StrangerListAdapter VI = jVar3.VI();
                    strangerListModel3 = this.btE.btz;
                    VI.setData(strangerListModel3.getData());
                }
            }
        }
    }
}
