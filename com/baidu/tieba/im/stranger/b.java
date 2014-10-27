package com.baidu.tieba.im.stranger;
/* loaded from: classes.dex */
class b implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ StrangerListActivity biq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(StrangerListActivity strangerListActivity) {
        this.biq = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        aVar2 = this.biq.bin;
        aVar2.dismiss();
    }
}
