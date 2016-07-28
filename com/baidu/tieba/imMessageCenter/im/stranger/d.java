package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class d implements a.b {
    final /* synthetic */ StrangerListActivity dgn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(StrangerListActivity strangerListActivity) {
        this.dgn = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        StrangerListModel strangerListModel;
        aVar2 = this.dgn.dgk;
        aVar2.dismiss();
        strangerListModel = this.dgn.dgi;
        strangerListModel.aua();
        this.dgn.showToast(u.j.cash_del_suc, false);
        this.dgn.finish();
    }
}
