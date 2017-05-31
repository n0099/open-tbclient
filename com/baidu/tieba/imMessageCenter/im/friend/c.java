package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.im.data.BlackListItemData;
import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements a.b {
    final /* synthetic */ IMBlackListActivity dkm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(IMBlackListActivity iMBlackListActivity) {
        this.dkm = iMBlackListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        BlackListItemData blackListItemData;
        BlackListModel blackListModel;
        BlackListItemData blackListItemData2;
        aVar.tc();
        blackListItemData = this.dkm.dkl;
        if (blackListItemData != null) {
            this.dkm.Pd();
            blackListModel = this.dkm.dkj;
            blackListItemData2 = this.dkm.dkl;
            blackListModel.removeFromBlackList(blackListItemData2.getUserId());
        }
    }
}
