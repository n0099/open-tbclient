package com.baidu.tieba.im.stranger;
/* loaded from: classes.dex */
class d implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ StrangerListActivity biE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(StrangerListActivity strangerListActivity) {
        this.biE = strangerListActivity;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void Km() {
        f fVar;
        f fVar2;
        StrangerListModel strangerListModel;
        StrangerListModel strangerListModel2;
        f fVar3;
        StrangerListModel strangerListModel3;
        fVar = this.biE.biy;
        if (fVar != null) {
            fVar2 = this.biE.biy;
            if (fVar2.RH() != null) {
                strangerListModel = this.biE.biz;
                if (strangerListModel != null) {
                    strangerListModel2 = this.biE.biz;
                    if (strangerListModel2.getData().size() == 0) {
                        this.biE.finish();
                    }
                    fVar3 = this.biE.biy;
                    StrangerListAdapter RH = fVar3.RH();
                    strangerListModel3 = this.biE.biz;
                    RH.setData(strangerListModel3.getData());
                }
            }
        }
    }
}
