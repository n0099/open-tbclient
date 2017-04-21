package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class d implements a.b {
    final /* synthetic */ StrangerListActivity dmm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(StrangerListActivity strangerListActivity) {
        this.dmm = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        StrangerListModel strangerListModel;
        aVar2 = this.dmm.dmj;
        aVar2.dismiss();
        strangerListModel = this.dmm.dmh;
        strangerListModel.awb();
        this.dmm.showToast(w.l.delete_success, false);
        this.dmm.finish();
    }
}
