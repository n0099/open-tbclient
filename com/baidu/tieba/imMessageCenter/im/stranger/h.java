package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class h implements c.b {
    private final /* synthetic */ ImMessageCenterShowItemData dkh;
    final /* synthetic */ StrangerListActivity dmm;
    private final /* synthetic */ int dmn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dmm = strangerListActivity;
        this.dmn = i;
        this.dkh = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.a.a aVar;
        StrangerListModel strangerListModel2;
        cVar.dismiss();
        if (this.dmn == 1) {
            strangerListModel2 = this.dmm.dmh;
            strangerListModel2.awb();
            this.dmm.finish();
            return;
        }
        strangerListModel = this.dmm.dmh;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.dkh;
        aVar = this.dmm.cSx;
        strangerListModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
