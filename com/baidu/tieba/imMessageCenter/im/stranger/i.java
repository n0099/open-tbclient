package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class i implements com.baidu.tbadk.core.dialog.h {
    private final /* synthetic */ ImMessageCenterShowItemData bsz;
    final /* synthetic */ StrangerListActivity bwE;
    private final /* synthetic */ int bwF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.bwE = strangerListActivity;
        this.bwF = i;
        this.bsz = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        StrangerListModel strangerListModel2;
        eVar.dismiss();
        if (this.bwF == 1) {
            strangerListModel2 = this.bwE.bwz;
            strangerListModel2.Xn();
            this.bwE.finish();
            return;
        }
        strangerListModel = this.bwE.bwz;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.bsz;
        aVar = this.bwE.bcB;
        strangerListModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
