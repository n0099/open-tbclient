package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class h implements c.b {
    private final /* synthetic */ ImMessageCenterShowItemData bKH;
    final /* synthetic */ StrangerListActivity bOR;
    private final /* synthetic */ int bOS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.bOR = strangerListActivity;
        this.bOS = i;
        this.bKH = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        StrangerListModel strangerListModel2;
        cVar.dismiss();
        if (this.bOS == 1) {
            strangerListModel2 = this.bOR.bOM;
            strangerListModel2.aaa();
            this.bOR.finish();
            return;
        }
        strangerListModel = this.bOR.bOM;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.bKH;
        aVar = this.bOR.buF;
        strangerListModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
