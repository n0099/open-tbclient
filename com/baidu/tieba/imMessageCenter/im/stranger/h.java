package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class h implements c.b {
    private final /* synthetic */ ImMessageCenterShowItemData csR;
    final /* synthetic */ StrangerListActivity cwY;
    private final /* synthetic */ int val$size;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.cwY = strangerListActivity;
        this.val$size = i;
        this.csR = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        StrangerListModel strangerListModel2;
        cVar.dismiss();
        if (this.val$size == 1) {
            strangerListModel2 = this.cwY.cwT;
            strangerListModel2.akT();
            this.cwY.finish();
            return;
        }
        strangerListModel = this.cwY.cwT;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.csR;
        aVar = this.cwY.cbL;
        strangerListModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
