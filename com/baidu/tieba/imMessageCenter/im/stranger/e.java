package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.tieba.t;
/* loaded from: classes.dex */
class e implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ StrangerListActivity bwE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(StrangerListActivity strangerListActivity) {
        this.bwE = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        StrangerListModel strangerListModel;
        aVar2 = this.bwE.bwB;
        aVar2.dismiss();
        strangerListModel = this.bwE.bwz;
        strangerListModel.Xn();
        this.bwE.showToast(t.cash_del_suc, false);
        this.bwE.finish();
    }
}
