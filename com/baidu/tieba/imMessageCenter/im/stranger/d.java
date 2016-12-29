package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class d implements a.b {
    final /* synthetic */ StrangerListActivity dbR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(StrangerListActivity strangerListActivity) {
        this.dbR = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        StrangerListModel strangerListModel;
        aVar2 = this.dbR.dbO;
        aVar2.dismiss();
        strangerListModel = this.dbR.dbM;
        strangerListModel.auF();
        this.dbR.showToast(r.j.delete_success, false);
        this.dbR.finish();
    }
}
