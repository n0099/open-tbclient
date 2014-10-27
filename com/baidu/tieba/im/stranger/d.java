package com.baidu.tieba.im.stranger;
/* loaded from: classes.dex */
class d implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ StrangerListActivity biq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(StrangerListActivity strangerListActivity) {
        this.biq = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void Ki() {
        f fVar;
        f fVar2;
        StrangerListModel strangerListModel;
        StrangerListModel strangerListModel2;
        f fVar3;
        StrangerListModel strangerListModel3;
        fVar = this.biq.bik;
        if (fVar != null) {
            fVar2 = this.biq.bik;
            if (fVar2.RE() != null) {
                strangerListModel = this.biq.bil;
                if (strangerListModel != null) {
                    strangerListModel2 = this.biq.bil;
                    if (strangerListModel2.getData().size() == 0) {
                        this.biq.finish();
                    }
                    fVar3 = this.biq.bik;
                    StrangerListAdapter RE = fVar3.RE();
                    strangerListModel3 = this.biq.bil;
                    RE.setData(strangerListModel3.getData());
                }
            }
        }
    }
}
