package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class d implements a.b {
    final /* synthetic */ StrangerListActivity drU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(StrangerListActivity strangerListActivity) {
        this.drU = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        StrangerListModel strangerListModel;
        aVar2 = this.drU.drR;
        aVar2.dismiss();
        strangerListModel = this.drU.drP;
        strangerListModel.ayO();
        this.drU.showToast(t.j.cash_del_suc, false);
        this.drU.finish();
    }
}
