package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
class d implements a.b {
    final /* synthetic */ StrangerListActivity dgq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(StrangerListActivity strangerListActivity) {
        this.dgq = strangerListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        StrangerListModel strangerListModel;
        aVar2 = this.dgq.dgn;
        aVar2.dismiss();
        strangerListModel = this.dgq.dgl;
        strangerListModel.asW();
        this.dgq.showToast(w.l.delete_success, false);
        this.dgq.finish();
    }
}
