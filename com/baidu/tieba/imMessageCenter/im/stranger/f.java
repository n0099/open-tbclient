package com.baidu.tieba.imMessageCenter.im.stranger;
/* loaded from: classes.dex */
class f implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ StrangerListActivity bwD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(StrangerListActivity strangerListActivity) {
        this.bwD = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        aVar2 = this.bwD.bwA;
        aVar2.dismiss();
    }
}
