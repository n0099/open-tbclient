package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.tieba.y;
/* loaded from: classes.dex */
class e implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ StrangerListActivity btU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(StrangerListActivity strangerListActivity) {
        this.btU = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        StrangerListModel strangerListModel;
        aVar2 = this.btU.btR;
        aVar2.dismiss();
        strangerListModel = this.btU.btP;
        strangerListModel.VU();
        this.btU.showToast(y.cash_del_suc, false);
        this.btU.finish();
    }
}
