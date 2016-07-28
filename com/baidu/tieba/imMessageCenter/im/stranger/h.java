package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class h implements c.b {
    private final /* synthetic */ ImMessageCenterShowItemData dcb;
    final /* synthetic */ StrangerListActivity dgn;
    private final /* synthetic */ int dgo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dgn = strangerListActivity;
        this.dgo = i;
        this.dcb = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        StrangerListModel strangerListModel2;
        cVar.dismiss();
        if (this.dgo == 1) {
            strangerListModel2 = this.dgn.dgi;
            strangerListModel2.aua();
            this.dgn.finish();
            return;
        }
        strangerListModel = this.dgn.dgi;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.dcb;
        aVar = this.dgn.cKB;
        strangerListModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
