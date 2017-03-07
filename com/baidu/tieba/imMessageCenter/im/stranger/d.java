package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class d implements a.b {
    final /* synthetic */ StrangerListActivity dlw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(StrangerListActivity strangerListActivity) {
        this.dlw = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        StrangerListModel strangerListModel;
        aVar2 = this.dlw.dlt;
        aVar2.dismiss();
        strangerListModel = this.dlw.dlr;
        strangerListModel.avh();
        this.dlw.showToast(w.l.delete_success, false);
        this.dlw.finish();
    }
}
