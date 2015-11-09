package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class d implements a.b {
    final /* synthetic */ StrangerListActivity bOR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(StrangerListActivity strangerListActivity) {
        this.bOR = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        StrangerListModel strangerListModel;
        aVar2 = this.bOR.bOO;
        aVar2.dismiss();
        strangerListModel = this.bOR.bOM;
        strangerListModel.aaa();
        this.bOR.showToast(i.h.cash_del_suc, false);
        this.bOR.finish();
    }
}
