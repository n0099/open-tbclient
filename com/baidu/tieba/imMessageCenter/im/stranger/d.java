package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class d implements a.b {
    final /* synthetic */ StrangerListActivity ddq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(StrangerListActivity strangerListActivity) {
        this.ddq = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        StrangerListModel strangerListModel;
        aVar2 = this.ddq.ddn;
        aVar2.dismiss();
        strangerListModel = this.ddq.ddl;
        strangerListModel.ato();
        this.ddq.showToast(u.j.cash_del_suc, false);
        this.ddq.finish();
    }
}
