package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.tieba.t;
/* loaded from: classes.dex */
class e implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ StrangerListActivity bwD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(StrangerListActivity strangerListActivity) {
        this.bwD = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        StrangerListModel strangerListModel;
        aVar2 = this.bwD.bwA;
        aVar2.dismiss();
        strangerListModel = this.bwD.bwy;
        strangerListModel.Xm();
        this.bwD.showToast(t.cash_del_suc, false);
        this.bwD.finish();
    }
}
