package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class h implements c.b {
    private final /* synthetic */ ImMessageCenterShowItemData cZK;
    final /* synthetic */ StrangerListActivity dbR;
    private final /* synthetic */ int dbS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dbR = strangerListActivity;
        this.dbS = i;
        this.cZK = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.a.a aVar;
        StrangerListModel strangerListModel2;
        cVar.dismiss();
        if (this.dbS == 1) {
            strangerListModel2 = this.dbR.dbM;
            strangerListModel2.auF();
            this.dbR.finish();
            return;
        }
        strangerListModel = this.dbR.dbM;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.cZK;
        aVar = this.dbR.cIl;
        strangerListModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
