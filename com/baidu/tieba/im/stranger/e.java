package com.baidu.tieba.im.stranger;

import android.content.DialogInterface;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class e implements DialogInterface.OnClickListener {
    private final /* synthetic */ ImMessageCenterShowItemData aTF;
    final /* synthetic */ StrangerListActivity bpq;
    private final /* synthetic */ int bpr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.bpq = strangerListActivity;
        this.bpr = i;
        this.aTF = imMessageCenterShowItemData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        StrangerListModel strangerListModel2;
        if (this.bpr == 1) {
            strangerListModel2 = this.bpq.bpl;
            strangerListModel2.Tr();
            this.bpq.finish();
            return;
        }
        strangerListModel = this.bpq.bpl;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.aTF;
        aVar = this.bpq.aTC;
        strangerListModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
