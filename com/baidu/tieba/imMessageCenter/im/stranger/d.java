package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class d implements a.b {
    final /* synthetic */ StrangerListActivity cdU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(StrangerListActivity strangerListActivity) {
        this.cdU = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        StrangerListModel strangerListModel;
        aVar2 = this.cdU.cdR;
        aVar2.dismiss();
        strangerListModel = this.cdU.cdP;
        strangerListModel.adg();
        this.cdU.showToast(n.i.cash_del_suc, false);
        this.cdU.finish();
    }
}
