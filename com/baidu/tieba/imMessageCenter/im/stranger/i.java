package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class i implements com.baidu.tbadk.core.dialog.h {
    private final /* synthetic */ ImMessageCenterShowItemData bpD;
    final /* synthetic */ StrangerListActivity btE;
    private final /* synthetic */ int btF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.btE = strangerListActivity;
        this.btF = i;
        this.bpD = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        StrangerListModel strangerListModel2;
        eVar.dismiss();
        if (this.btF == 1) {
            strangerListModel2 = this.btE.btz;
            strangerListModel2.VH();
            this.btE.finish();
            return;
        }
        strangerListModel = this.btE.btz;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.bpD;
        aVar = this.btE.aZD;
        strangerListModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
