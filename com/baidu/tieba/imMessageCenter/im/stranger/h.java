package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes2.dex */
class h implements c.b {
    private final /* synthetic */ ImMessageCenterShowItemData drA;
    final /* synthetic */ StrangerListActivity dtI;
    private final /* synthetic */ int dtJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dtI = strangerListActivity;
        this.dtJ = i;
        this.drA = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.a.a aVar;
        StrangerListModel strangerListModel2;
        cVar.dismiss();
        if (this.dtJ == 1) {
            strangerListModel2 = this.dtI.dtD;
            strangerListModel2.axz();
            this.dtI.finish();
            return;
        }
        strangerListModel = this.dtI.dtD;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.drA;
        aVar = this.dtI.cZT;
        strangerListModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
