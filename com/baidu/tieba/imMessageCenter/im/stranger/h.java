package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class h implements c.b {
    private final /* synthetic */ ImMessageCenterShowItemData dnJ;
    final /* synthetic */ StrangerListActivity drU;
    private final /* synthetic */ int drV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.drU = strangerListActivity;
        this.drV = i;
        this.dnJ = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        StrangerListModel strangerListModel2;
        cVar.dismiss();
        if (this.drV == 1) {
            strangerListModel2 = this.drU.drP;
            strangerListModel2.ayO();
            this.drU.finish();
            return;
        }
        strangerListModel = this.drU.drP;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.dnJ;
        aVar = this.drU.cWg;
        strangerListModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
