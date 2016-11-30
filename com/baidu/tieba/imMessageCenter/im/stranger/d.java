package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class d implements a.b {
    final /* synthetic */ StrangerListActivity dyW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(StrangerListActivity strangerListActivity) {
        this.dyW = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        StrangerListModel strangerListModel;
        aVar2 = this.dyW.dyT;
        aVar2.dismiss();
        strangerListModel = this.dyW.dyR;
        strangerListModel.aBj();
        this.dyW.showToast(r.j.cash_del_suc, false);
        this.dyW.finish();
    }
}
