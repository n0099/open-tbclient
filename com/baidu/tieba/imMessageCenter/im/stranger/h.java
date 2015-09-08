package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class h implements c.b {
    private final /* synthetic */ ImMessageCenterShowItemData bGW;
    final /* synthetic */ StrangerListActivity bLb;
    private final /* synthetic */ int bLc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.bLb = strangerListActivity;
        this.bLc = i;
        this.bGW = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        StrangerListModel strangerListModel2;
        cVar.dismiss();
        if (this.bLc == 1) {
            strangerListModel2 = this.bLb.bKW;
            strangerListModel2.YV();
            this.bLb.finish();
            return;
        }
        strangerListModel = this.bLb.bKW;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.bGW;
        aVar = this.bLb.bqT;
        strangerListModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
