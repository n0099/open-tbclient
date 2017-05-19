package com.baidu.tieba.imMessageCenter.im.stranger;
/* loaded from: classes2.dex */
class g implements com.baidu.tieba.im.chat.a.a {
    final /* synthetic */ StrangerListActivity dgq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(StrangerListActivity strangerListActivity) {
        this.dgq = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.a.a
    public void onComplete() {
        i iVar;
        i iVar2;
        StrangerListModel strangerListModel;
        StrangerListModel strangerListModel2;
        i iVar3;
        StrangerListModel strangerListModel3;
        iVar = this.dgq.dgk;
        if (iVar != null) {
            iVar2 = this.dgq.dgk;
            if (iVar2.asX() != null) {
                strangerListModel = this.dgq.dgl;
                if (strangerListModel != null) {
                    strangerListModel2 = this.dgq.dgl;
                    if (strangerListModel2.getData().size() == 0) {
                        this.dgq.finish();
                    }
                    iVar3 = this.dgq.dgk;
                    StrangerListAdapter asX = iVar3.asX();
                    strangerListModel3 = this.dgq.dgl;
                    asX.setData(strangerListModel3.getData());
                }
            }
        }
    }
}
