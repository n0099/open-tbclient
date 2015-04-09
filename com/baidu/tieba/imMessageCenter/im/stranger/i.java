package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class i implements com.baidu.tbadk.core.dialog.h {
    private final /* synthetic */ ImMessageCenterShowItemData bpT;
    final /* synthetic */ StrangerListActivity btU;
    private final /* synthetic */ int btV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.btU = strangerListActivity;
        this.btV = i;
        this.bpT = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        StrangerListModel strangerListModel2;
        eVar.dismiss();
        if (this.btV == 1) {
            strangerListModel2 = this.btU.btP;
            strangerListModel2.VU();
            this.btU.finish();
            return;
        }
        strangerListModel = this.btU.btP;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.bpT;
        aVar = this.btU.aZT;
        strangerListModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
