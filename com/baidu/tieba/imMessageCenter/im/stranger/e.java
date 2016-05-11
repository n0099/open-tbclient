package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class e implements a.b {
    final /* synthetic */ StrangerListActivity cxV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(StrangerListActivity strangerListActivity) {
        this.cxV = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        aVar2 = this.cxV.cxS;
        aVar2.dismiss();
    }
}
