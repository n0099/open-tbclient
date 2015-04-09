package com.baidu.tieba.imMessageCenter.im.stranger;
/* loaded from: classes.dex */
class f implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ StrangerListActivity btU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(StrangerListActivity strangerListActivity) {
        this.btU = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        aVar2 = this.btU.btR;
        aVar2.dismiss();
    }
}
