package com.baidu.tieba.imMessageCenter.im.stranger;
/* loaded from: classes.dex */
class h implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ StrangerListActivity bwE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(StrangerListActivity strangerListActivity) {
        this.bwE = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        j jVar;
        j jVar2;
        StrangerListModel strangerListModel;
        StrangerListModel strangerListModel2;
        j jVar3;
        StrangerListModel strangerListModel3;
        jVar = this.bwE.bwy;
        if (jVar != null) {
            jVar2 = this.bwE.bwy;
            if (jVar2.Xo() != null) {
                strangerListModel = this.bwE.bwz;
                if (strangerListModel != null) {
                    strangerListModel2 = this.bwE.bwz;
                    if (strangerListModel2.getData().size() == 0) {
                        this.bwE.finish();
                    }
                    jVar3 = this.bwE.bwy;
                    StrangerListAdapter Xo = jVar3.Xo();
                    strangerListModel3 = this.bwE.bwz;
                    Xo.setData(strangerListModel3.getData());
                }
            }
        }
    }
}
