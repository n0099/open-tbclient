package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class h implements c.b {
    private final /* synthetic */ ImMessageCenterShowItemData dgZ;
    final /* synthetic */ StrangerListActivity djd;
    private final /* synthetic */ int dje;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.djd = strangerListActivity;
        this.dje = i;
        this.dgZ = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.a.a aVar;
        StrangerListModel strangerListModel2;
        cVar.dismiss();
        if (this.dje == 1) {
            strangerListModel2 = this.djd.diY;
            strangerListModel2.avL();
            this.djd.finish();
            return;
        }
        strangerListModel = this.djd.diY;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.dgZ;
        aVar = this.djd.cPs;
        strangerListModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
