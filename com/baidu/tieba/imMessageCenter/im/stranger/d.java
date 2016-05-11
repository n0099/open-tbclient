package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class d implements a.b {
    final /* synthetic */ StrangerListActivity cxV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(StrangerListActivity strangerListActivity) {
        this.cxV = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        StrangerListModel strangerListModel;
        aVar2 = this.cxV.cxS;
        aVar2.dismiss();
        strangerListModel = this.cxV.cxQ;
        strangerListModel.akZ();
        this.cxV.showToast(t.j.cash_del_suc, false);
        this.cxV.finish();
    }
}
