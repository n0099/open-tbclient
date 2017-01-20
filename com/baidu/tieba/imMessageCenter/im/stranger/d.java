package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class d implements a.b {
    final /* synthetic */ StrangerListActivity djd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(StrangerListActivity strangerListActivity) {
        this.djd = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        StrangerListModel strangerListModel;
        aVar2 = this.djd.dja;
        aVar2.dismiss();
        strangerListModel = this.djd.diY;
        strangerListModel.avL();
        this.djd.showToast(r.l.delete_success, false);
        this.djd.finish();
    }
}
