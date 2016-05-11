package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class h implements c.b {
    private final /* synthetic */ ImMessageCenterShowItemData ctP;
    final /* synthetic */ StrangerListActivity cxV;
    private final /* synthetic */ int cxW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.cxV = strangerListActivity;
        this.cxW = i;
        this.ctP = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        StrangerListModel strangerListModel2;
        cVar.dismiss();
        if (this.cxW == 1) {
            strangerListModel2 = this.cxV.cxQ;
            strangerListModel2.akZ();
            this.cxV.finish();
            return;
        }
        strangerListModel = this.cxV.cxQ;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.ctP;
        aVar = this.cxV.ccq;
        strangerListModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
