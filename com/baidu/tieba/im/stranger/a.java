package com.baidu.tieba.im.stranger;

import com.baidu.tieba.z;
/* loaded from: classes.dex */
class a implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ StrangerListActivity bnU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(StrangerListActivity strangerListActivity) {
        this.bnU = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        StrangerListModel strangerListModel;
        aVar2 = this.bnU.bnR;
        aVar2.dismiss();
        strangerListModel = this.bnU.bnP;
        strangerListModel.Ta();
        this.bnU.showToast(z.cash_del_suc, false);
        this.bnU.finish();
    }
}
