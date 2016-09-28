package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class h implements c.b {
    private final /* synthetic */ ImMessageCenterShowItemData dph;
    final /* synthetic */ StrangerListActivity dtr;
    private final /* synthetic */ int dts;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dtr = strangerListActivity;
        this.dts = i;
        this.dph = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        StrangerListModel strangerListModel2;
        cVar.dismiss();
        if (this.dts == 1) {
            strangerListModel2 = this.dtr.dtm;
            strangerListModel2.azm();
            this.dtr.finish();
            return;
        }
        strangerListModel = this.dtr.dtm;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.dph;
        aVar = this.dtr.cXD;
        strangerListModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
