package com.baidu.tieba.im.stranger;

import com.baidu.tieba.y;
/* loaded from: classes.dex */
class h implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ StrangerListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(StrangerListActivity strangerListActivity) {
        this.a = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        o oVar;
        l lVar;
        aVar2 = this.a.e;
        aVar2.c();
        this.a.showLoadingDialog(this.a.getString(y.deleting), null);
        oVar = this.a.c;
        lVar = this.a.j;
        oVar.a(lVar);
    }
}
