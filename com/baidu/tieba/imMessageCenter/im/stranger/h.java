package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class h implements c.b {
    private final /* synthetic */ ImMessageCenterShowItemData bZL;
    final /* synthetic */ StrangerListActivity cdU;
    private final /* synthetic */ int cdV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.cdU = strangerListActivity;
        this.cdV = i;
        this.bZL = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        StrangerListModel strangerListModel2;
        cVar.dismiss();
        if (this.cdV == 1) {
            strangerListModel2 = this.cdU.cdP;
            strangerListModel2.adg();
            this.cdU.finish();
            return;
        }
        strangerListModel = this.cdU.cdP;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.bZL;
        aVar = this.cdU.bJK;
        strangerListModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
