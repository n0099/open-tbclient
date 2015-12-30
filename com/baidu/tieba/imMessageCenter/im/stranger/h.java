package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class h implements c.b {
    private final /* synthetic */ ImMessageCenterShowItemData cdM;
    final /* synthetic */ StrangerListActivity chU;
    private final /* synthetic */ int chV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.chU = strangerListActivity;
        this.chV = i;
        this.cdM = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        StrangerListModel strangerListModel2;
        cVar.dismiss();
        if (this.chV == 1) {
            strangerListModel2 = this.chU.chP;
            strangerListModel2.aep();
            this.chU.finish();
            return;
        }
        strangerListModel = this.chU.chP;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.cdM;
        aVar = this.chU.bNs;
        strangerListModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
