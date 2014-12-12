package com.baidu.tieba.im.stranger;
/* loaded from: classes.dex */
class d implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ StrangerListActivity bnU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(StrangerListActivity strangerListActivity) {
        this.bnU = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        f fVar;
        f fVar2;
        StrangerListModel strangerListModel;
        StrangerListModel strangerListModel2;
        f fVar3;
        StrangerListModel strangerListModel3;
        fVar = this.bnU.bnO;
        if (fVar != null) {
            fVar2 = this.bnU.bnO;
            if (fVar2.Tb() != null) {
                strangerListModel = this.bnU.bnP;
                if (strangerListModel != null) {
                    strangerListModel2 = this.bnU.bnP;
                    if (strangerListModel2.getData().size() == 0) {
                        this.bnU.finish();
                    }
                    fVar3 = this.bnU.bnO;
                    StrangerListAdapter Tb = fVar3.Tb();
                    strangerListModel3 = this.bnU.bnP;
                    Tb.setData(strangerListModel3.getData());
                }
            }
        }
    }
}
