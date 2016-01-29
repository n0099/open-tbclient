package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class h implements c.b {
    private final /* synthetic */ ImMessageCenterShowItemData cim;
    final /* synthetic */ StrangerListActivity cmw;
    private final /* synthetic */ int val$size;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.cmw = strangerListActivity;
        this.val$size = i;
        this.cim = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        StrangerListModel strangerListModel2;
        cVar.dismiss();
        if (this.val$size == 1) {
            strangerListModel2 = this.cmw.cmr;
            strangerListModel2.ahz();
            this.cmw.finish();
            return;
        }
        strangerListModel = this.cmw.cmr;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.cim;
        aVar = this.cmw.bRq;
        strangerListModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
