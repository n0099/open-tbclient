package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.tieba.y;
/* loaded from: classes.dex */
class e implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ StrangerListActivity btE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(StrangerListActivity strangerListActivity) {
        this.btE = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        StrangerListModel strangerListModel;
        aVar2 = this.btE.btB;
        aVar2.dismiss();
        strangerListModel = this.btE.btz;
        strangerListModel.VH();
        this.btE.showToast(y.cash_del_suc, false);
        this.btE.finish();
    }
}
