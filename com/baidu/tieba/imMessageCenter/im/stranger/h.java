package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes2.dex */
class h implements c.b {
    private final /* synthetic */ ImMessageCenterShowItemData dej;
    final /* synthetic */ StrangerListActivity dgq;
    private final /* synthetic */ int dgr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dgq = strangerListActivity;
        this.dgr = i;
        this.dej = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.a.a aVar;
        StrangerListModel strangerListModel2;
        cVar.dismiss();
        if (this.dgr == 1) {
            strangerListModel2 = this.dgq.dgl;
            strangerListModel2.asW();
            this.dgq.finish();
            return;
        }
        strangerListModel = this.dgq.dgl;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.dej;
        aVar = this.dgq.cMz;
        strangerListModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
