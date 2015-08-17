package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class d implements a.b {
    final /* synthetic */ StrangerListActivity bKu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(StrangerListActivity strangerListActivity) {
        this.bKu = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        StrangerListModel strangerListModel;
        aVar2 = this.bKu.bKr;
        aVar2.dismiss();
        strangerListModel = this.bKu.bKp;
        strangerListModel.YT();
        this.bKu.showToast(i.C0057i.cash_del_suc, false);
        this.bKu.finish();
    }
}
