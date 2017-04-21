package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.im.data.BlackListItemData;
import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    final /* synthetic */ IMBlackListActivity dkP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(IMBlackListActivity iMBlackListActivity) {
        this.dkP = iMBlackListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        BlackListItemData blackListItemData;
        BlackListModel blackListModel;
        BlackListItemData blackListItemData2;
        aVar.tQ();
        blackListItemData = this.dkP.dkO;
        if (blackListItemData != null) {
            this.dkP.avw();
            blackListModel = this.dkP.dkM;
            blackListItemData2 = this.dkP.dkO;
            blackListModel.removeFromBlackList(blackListItemData2.getUserId());
        }
    }
}
