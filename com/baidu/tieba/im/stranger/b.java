package com.baidu.tieba.im.stranger;
/* loaded from: classes.dex */
class b implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ StrangerListActivity bpq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(StrangerListActivity strangerListActivity) {
        this.bpq = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        aVar2 = this.bpq.bpn;
        aVar2.dismiss();
    }
}
