package com.baidu.tieba.imMessageCenter.im.stranger;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.im.chat.a.a {
    final /* synthetic */ StrangerListActivity djV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(StrangerListActivity strangerListActivity) {
        this.djV = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.a.a
    public void onComplete() {
        i iVar;
        i iVar2;
        StrangerListModel strangerListModel;
        StrangerListModel strangerListModel2;
        i iVar3;
        StrangerListModel strangerListModel3;
        iVar = this.djV.djP;
        if (iVar != null) {
            iVar2 = this.djV.djP;
            if (iVar2.avb() != null) {
                strangerListModel = this.djV.djQ;
                if (strangerListModel != null) {
                    strangerListModel2 = this.djV.djQ;
                    if (strangerListModel2.getData().size() == 0) {
                        this.djV.finish();
                    }
                    iVar3 = this.djV.djP;
                    StrangerListAdapter avb = iVar3.avb();
                    strangerListModel3 = this.djV.djQ;
                    avb.setData(strangerListModel3.getData());
                }
            }
        }
    }
}
