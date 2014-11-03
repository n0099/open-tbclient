package com.baidu.tieba.im.stranger;

import android.content.DialogInterface;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class e implements DialogInterface.OnClickListener {
    private final /* synthetic */ ImMessageCenterShowItemData aQS;
    final /* synthetic */ StrangerListActivity biE;
    private final /* synthetic */ int biF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.biE = strangerListActivity;
        this.biF = i;
        this.aQS = imMessageCenterShowItemData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        StrangerListModel strangerListModel2;
        if (this.biF == 1) {
            strangerListModel2 = this.biE.biz;
            strangerListModel2.RG();
            this.biE.finish();
            return;
        }
        strangerListModel = this.biE.biz;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.aQS;
        aVar = this.biE.aQP;
        strangerListModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
