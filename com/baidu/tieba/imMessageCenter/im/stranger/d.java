package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class d implements a.b {
    final /* synthetic */ StrangerListActivity bOw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(StrangerListActivity strangerListActivity) {
        this.bOw = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        StrangerListModel strangerListModel;
        aVar2 = this.bOw.bOt;
        aVar2.dismiss();
        strangerListModel = this.bOw.bOr;
        strangerListModel.ZJ();
        this.bOw.showToast(i.h.cash_del_suc, false);
        this.bOw.finish();
    }
}
