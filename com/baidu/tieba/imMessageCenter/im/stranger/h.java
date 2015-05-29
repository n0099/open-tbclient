package com.baidu.tieba.imMessageCenter.im.stranger;
/* loaded from: classes.dex */
class h implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ StrangerListActivity bwD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(StrangerListActivity strangerListActivity) {
        this.bwD = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        j jVar;
        j jVar2;
        StrangerListModel strangerListModel;
        StrangerListModel strangerListModel2;
        j jVar3;
        StrangerListModel strangerListModel3;
        jVar = this.bwD.bwx;
        if (jVar != null) {
            jVar2 = this.bwD.bwx;
            if (jVar2.Xn() != null) {
                strangerListModel = this.bwD.bwy;
                if (strangerListModel != null) {
                    strangerListModel2 = this.bwD.bwy;
                    if (strangerListModel2.getData().size() == 0) {
                        this.bwD.finish();
                    }
                    jVar3 = this.bwD.bwx;
                    StrangerListAdapter Xn = jVar3.Xn();
                    strangerListModel3 = this.bwD.bwy;
                    Xn.setData(strangerListModel3.getData());
                }
            }
        }
    }
}
