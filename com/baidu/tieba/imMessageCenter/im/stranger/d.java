package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class d implements a.b {
    final /* synthetic */ StrangerListActivity cwY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(StrangerListActivity strangerListActivity) {
        this.cwY = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        StrangerListModel strangerListModel;
        aVar2 = this.cwY.cwV;
        aVar2.dismiss();
        strangerListModel = this.cwY.cwT;
        strangerListModel.akT();
        this.cwY.showToast(t.j.cash_del_suc, false);
        this.cwY.finish();
    }
}
