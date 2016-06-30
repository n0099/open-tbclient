package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class h implements c.b {
    private final /* synthetic */ ImMessageCenterShowItemData cZe;
    final /* synthetic */ StrangerListActivity ddq;
    private final /* synthetic */ int ddr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.ddq = strangerListActivity;
        this.ddr = i;
        this.cZe = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        StrangerListModel strangerListModel2;
        cVar.dismiss();
        if (this.ddr == 1) {
            strangerListModel2 = this.ddq.ddl;
            strangerListModel2.ato();
            this.ddq.finish();
            return;
        }
        strangerListModel = this.ddq.ddl;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.cZe;
        aVar = this.ddq.cHM;
        strangerListModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
