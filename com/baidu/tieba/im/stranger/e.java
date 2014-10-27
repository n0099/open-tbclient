package com.baidu.tieba.im.stranger;

import android.content.DialogInterface;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class e implements DialogInterface.OnClickListener {
    private final /* synthetic */ ImMessageCenterShowItemData aQE;
    final /* synthetic */ StrangerListActivity biq;
    private final /* synthetic */ int bir;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.biq = strangerListActivity;
        this.bir = i;
        this.aQE = imMessageCenterShowItemData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        StrangerListModel strangerListModel2;
        if (this.bir == 1) {
            strangerListModel2 = this.biq.bil;
            strangerListModel2.RD();
            this.biq.finish();
            return;
        }
        strangerListModel = this.biq.bil;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.aQE;
        aVar = this.biq.aQB;
        strangerListModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
