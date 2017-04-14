package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class h implements c.b {
    private final /* synthetic */ ImMessageCenterShowItemData dhQ;
    final /* synthetic */ StrangerListActivity djV;
    private final /* synthetic */ int djW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.djV = strangerListActivity;
        this.djW = i;
        this.dhQ = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.a.a aVar;
        StrangerListModel strangerListModel2;
        cVar.dismiss();
        if (this.djW == 1) {
            strangerListModel2 = this.djV.djQ;
            strangerListModel2.ava();
            this.djV.finish();
            return;
        }
        strangerListModel = this.djV.djQ;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.dhQ;
        aVar = this.djV.cQg;
        strangerListModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
