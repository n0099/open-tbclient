package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class h implements c.b {
    private final /* synthetic */ ImMessageCenterShowItemData bKb;
    final /* synthetic */ StrangerListActivity bOl;
    private final /* synthetic */ int bOm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.bOl = strangerListActivity;
        this.bOm = i;
        this.bKb = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        StrangerListModel strangerListModel2;
        cVar.dismiss();
        if (this.bOm == 1) {
            strangerListModel2 = this.bOl.bOg;
            strangerListModel2.ZJ();
            this.bOl.finish();
            return;
        }
        strangerListModel = this.bOl.bOg;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.bKb;
        aVar = this.bOl.btU;
        strangerListModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
