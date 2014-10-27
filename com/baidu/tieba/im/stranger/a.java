package com.baidu.tieba.im.stranger;
/* loaded from: classes.dex */
class a implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ StrangerListActivity biq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(StrangerListActivity strangerListActivity) {
        this.biq = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        StrangerListModel strangerListModel;
        aVar2 = this.biq.bin;
        aVar2.dismiss();
        strangerListModel = this.biq.bil;
        strangerListModel.RD();
        this.biq.finish();
    }
}
