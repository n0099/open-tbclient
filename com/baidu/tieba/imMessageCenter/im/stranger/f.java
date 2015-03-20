package com.baidu.tieba.imMessageCenter.im.stranger;
/* loaded from: classes.dex */
class f implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ StrangerListActivity btE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(StrangerListActivity strangerListActivity) {
        this.btE = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        aVar2 = this.btE.btB;
        aVar2.dismiss();
    }
}
