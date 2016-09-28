package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class d implements a.b {
    final /* synthetic */ StrangerListActivity dtr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(StrangerListActivity strangerListActivity) {
        this.dtr = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        StrangerListModel strangerListModel;
        aVar2 = this.dtr.dto;
        aVar2.dismiss();
        strangerListModel = this.dtr.dtm;
        strangerListModel.azm();
        this.dtr.showToast(r.j.cash_del_suc, false);
        this.dtr.finish();
    }
}
