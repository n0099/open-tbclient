package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class d implements a.b {
    final /* synthetic */ StrangerListActivity bLb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(StrangerListActivity strangerListActivity) {
        this.bLb = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        StrangerListModel strangerListModel;
        aVar2 = this.bLb.bKY;
        aVar2.dismiss();
        strangerListModel = this.bLb.bKW;
        strangerListModel.YV();
        this.bLb.showToast(i.h.cash_del_suc, false);
        this.bLb.finish();
    }
}
