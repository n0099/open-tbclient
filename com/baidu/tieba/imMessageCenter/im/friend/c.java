package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.im.data.BlackListItemData;
import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    final /* synthetic */ IMBlackListActivity djZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(IMBlackListActivity iMBlackListActivity) {
        this.djZ = iMBlackListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        BlackListItemData blackListItemData;
        BlackListModel blackListModel;
        BlackListItemData blackListItemData2;
        aVar.ts();
        blackListItemData = this.djZ.djY;
        if (blackListItemData != null) {
            this.djZ.auC();
            blackListModel = this.djZ.djW;
            blackListItemData2 = this.djZ.djY;
            blackListModel.removeFromBlackList(blackListItemData2.getUserId());
        }
    }
}
