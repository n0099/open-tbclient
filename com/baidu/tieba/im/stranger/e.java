package com.baidu.tieba.im.stranger;

import android.content.DialogInterface;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class e implements DialogInterface.OnClickListener {
    private final /* synthetic */ ImMessageCenterShowItemData aTG;
    final /* synthetic */ StrangerListActivity bpr;
    private final /* synthetic */ int bps;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.bpr = strangerListActivity;
        this.bps = i;
        this.aTG = imMessageCenterShowItemData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        StrangerListModel strangerListModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        StrangerListModel strangerListModel2;
        if (this.bps == 1) {
            strangerListModel2 = this.bpr.bpm;
            strangerListModel2.Tw();
            this.bpr.finish();
            return;
        }
        strangerListModel = this.bpr.bpm;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.aTG;
        aVar = this.bpr.aTD;
        strangerListModel.deleteItem(imMessageCenterShowItemData, aVar);
    }
}
