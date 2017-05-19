package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.im.data.BlackListItemData;
import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements a.b {
    final /* synthetic */ IMBlackListActivity deS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(IMBlackListActivity iMBlackListActivity) {
        this.deS = iMBlackListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        BlackListItemData blackListItemData;
        BlackListModel blackListModel;
        BlackListItemData blackListItemData2;
        aVar.td();
        blackListItemData = this.deS.deR;
        if (blackListItemData != null) {
            this.deS.asr();
            blackListModel = this.deS.deP;
            blackListItemData2 = this.deS.deR;
            blackListModel.removeFromBlackList(blackListItemData2.getUserId());
        }
    }
}
