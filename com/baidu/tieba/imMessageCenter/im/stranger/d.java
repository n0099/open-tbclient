package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class d implements a.b {
    final /* synthetic */ StrangerListActivity cmw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(StrangerListActivity strangerListActivity) {
        this.cmw = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        StrangerListModel strangerListModel;
        aVar2 = this.cmw.cmt;
        aVar2.dismiss();
        strangerListModel = this.cmw.cmr;
        strangerListModel.ahz();
        this.cmw.showToast(t.j.cash_del_suc, false);
        this.cmw.finish();
    }
}
