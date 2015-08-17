package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class h implements c.b {
    private final /* synthetic */ ImMessageCenterShowItemData bGp;
    final /* synthetic */ StrangerListActivity bKu;
    private final /* synthetic */ int bKv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.bKu = strangerListActivity;
        this.bKv = i;
        this.bGp = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        StrangerListModel strangerListModel2;
        cVar.dismiss();
        if (this.bKv == 1) {
            strangerListModel2 = this.bKu.bKp;
            strangerListModel2.YT();
            this.bKu.finish();
            return;
        }
        strangerListModel = this.bKu.bKp;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.bGp;
        aVar = this.bKu.bqv;
        strangerListModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
