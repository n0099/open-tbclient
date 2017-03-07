package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
/* loaded from: classes.dex */
class h implements c.b {
    private final /* synthetic */ ImMessageCenterShowItemData djr;
    final /* synthetic */ StrangerListActivity dlw;
    private final /* synthetic */ int dlx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dlw = strangerListActivity;
        this.dlx = i;
        this.djr = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.a.a aVar;
        StrangerListModel strangerListModel2;
        cVar.dismiss();
        if (this.dlx == 1) {
            strangerListModel2 = this.dlw.dlr;
            strangerListModel2.avh();
            this.dlw.finish();
            return;
        }
        strangerListModel = this.dlw.dlr;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.djr;
        aVar = this.dlw.cRJ;
        strangerListModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
