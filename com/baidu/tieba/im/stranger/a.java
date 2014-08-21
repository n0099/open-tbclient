package com.baidu.tieba.im.stranger;
/* loaded from: classes.dex */
class a implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ StrangerListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(StrangerListActivity strangerListActivity) {
        this.a = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        h hVar;
        aVar2 = this.a.e;
        aVar2.d();
        hVar = this.a.c;
        hVar.b();
        this.a.finish();
    }
}
