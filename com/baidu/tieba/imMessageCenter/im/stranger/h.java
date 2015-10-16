package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class h implements c.b {
    private final /* synthetic */ ImMessageCenterShowItemData bKm;
    final /* synthetic */ StrangerListActivity bOw;
    private final /* synthetic */ int bOx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.bOw = strangerListActivity;
        this.bOx = i;
        this.bKm = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        StrangerListModel strangerListModel2;
        cVar.dismiss();
        if (this.bOx == 1) {
            strangerListModel2 = this.bOw.bOr;
            strangerListModel2.ZJ();
            this.bOw.finish();
            return;
        }
        strangerListModel = this.bOw.bOr;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.bKm;
        aVar = this.bOw.buf;
        strangerListModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
