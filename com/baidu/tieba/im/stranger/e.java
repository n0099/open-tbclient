package com.baidu.tieba.im.stranger;

import android.content.DialogInterface;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class e implements DialogInterface.OnClickListener {
    private final /* synthetic */ ImMessageCenterShowItemData aSw;
    final /* synthetic */ StrangerListActivity bnU;
    private final /* synthetic */ int bnV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.bnU = strangerListActivity;
        this.bnV = i;
        this.aSw = imMessageCenterShowItemData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        StrangerListModel strangerListModel2;
        if (this.bnV == 1) {
            strangerListModel2 = this.bnU.bnP;
            strangerListModel2.Ta();
            this.bnU.finish();
            return;
        }
        strangerListModel = this.bnU.bnP;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.aSw;
        aVar = this.bnU.aSt;
        strangerListModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
