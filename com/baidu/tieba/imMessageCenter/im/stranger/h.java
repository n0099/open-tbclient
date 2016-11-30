package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class h implements c.b {
    private final /* synthetic */ ImMessageCenterShowItemData duP;
    final /* synthetic */ StrangerListActivity dyW;
    private final /* synthetic */ int dyX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dyW = strangerListActivity;
        this.dyX = i;
        this.duP = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        StrangerListModel strangerListModel2;
        cVar.dismiss();
        if (this.dyX == 1) {
            strangerListModel2 = this.dyW.dyR;
            strangerListModel2.aBj();
            this.dyW.finish();
            return;
        }
        strangerListModel = this.dyW.dyR;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.duP;
        aVar = this.dyW.ddp;
        strangerListModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
