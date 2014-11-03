package com.baidu.tieba.im.stranger;
/* loaded from: classes.dex */
class a implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ StrangerListActivity biE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(StrangerListActivity strangerListActivity) {
        this.biE = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        StrangerListModel strangerListModel;
        aVar2 = this.biE.biB;
        aVar2.dismiss();
        strangerListModel = this.biE.biz;
        strangerListModel.RG();
        this.biE.finish();
    }
}
