package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.im.data.BlackListItemData;
import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    final /* synthetic */ IMBlackListActivity diy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(IMBlackListActivity iMBlackListActivity) {
        this.diy = iMBlackListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        BlackListItemData blackListItemData;
        BlackListModel blackListModel;
        BlackListItemData blackListItemData2;
        aVar.tQ();
        blackListItemData = this.diy.dix;
        if (blackListItemData != null) {
            this.diy.auv();
            blackListModel = this.diy.div;
            blackListItemData2 = this.diy.dix;
            blackListModel.removeFromBlackList(blackListItemData2.getUserId());
        }
    }
}
