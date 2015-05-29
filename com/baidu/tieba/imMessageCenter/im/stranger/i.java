package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class i implements com.baidu.tbadk.core.dialog.h {
    private final /* synthetic */ ImMessageCenterShowItemData bsy;
    final /* synthetic */ StrangerListActivity bwD;
    private final /* synthetic */ int bwE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.bwD = strangerListActivity;
        this.bwE = i;
        this.bsy = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        StrangerListModel strangerListModel2;
        eVar.dismiss();
        if (this.bwE == 1) {
            strangerListModel2 = this.bwD.bwy;
            strangerListModel2.Xm();
            this.bwD.finish();
            return;
        }
        strangerListModel = this.bwD.bwy;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.bsy;
        aVar = this.bwD.bcA;
        strangerListModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
