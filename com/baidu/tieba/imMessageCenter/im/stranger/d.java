package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class d implements a.b {
    final /* synthetic */ StrangerListActivity chU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(StrangerListActivity strangerListActivity) {
        this.chU = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        StrangerListModel strangerListModel;
        aVar2 = this.chU.chR;
        aVar2.dismiss();
        strangerListModel = this.chU.chP;
        strangerListModel.aep();
        this.chU.showToast(n.j.cash_del_suc, false);
        this.chU.finish();
    }
}
