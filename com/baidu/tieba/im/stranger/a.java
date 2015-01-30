package com.baidu.tieba.im.stranger;

import com.baidu.tieba.z;
/* loaded from: classes.dex */
class a implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ StrangerListActivity bpr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(StrangerListActivity strangerListActivity) {
        this.bpr = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        StrangerListModel strangerListModel;
        aVar2 = this.bpr.bpo;
        aVar2.dismiss();
        strangerListModel = this.bpr.bpm;
        strangerListModel.Tw();
        this.bpr.showToast(z.cash_del_suc, false);
        this.bpr.finish();
    }
}
