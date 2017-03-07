package com.baidu.tieba.imMessageCenter.im.stranger;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.im.chat.a.a {
    final /* synthetic */ StrangerListActivity dlw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(StrangerListActivity strangerListActivity) {
        this.dlw = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.a.a
    public void onComplete() {
        i iVar;
        i iVar2;
        StrangerListModel strangerListModel;
        StrangerListModel strangerListModel2;
        i iVar3;
        StrangerListModel strangerListModel3;
        iVar = this.dlw.dlq;
        if (iVar != null) {
            iVar2 = this.dlw.dlq;
            if (iVar2.avi() != null) {
                strangerListModel = this.dlw.dlr;
                if (strangerListModel != null) {
                    strangerListModel2 = this.dlw.dlr;
                    if (strangerListModel2.getData().size() == 0) {
                        this.dlw.finish();
                    }
                    iVar3 = this.dlw.dlq;
                    StrangerListAdapter avi = iVar3.avi();
                    strangerListModel3 = this.dlw.dlr;
                    avi.setData(strangerListModel3.getData());
                }
            }
        }
    }
}
