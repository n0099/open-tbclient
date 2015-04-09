package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ IMBlackListActivity bsu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(IMBlackListActivity iMBlackListActivity) {
        this.bsu = iMBlackListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.im.data.a aVar2;
        BlackListModel blackListModel;
        com.baidu.tieba.im.data.a aVar3;
        aVar.re();
        aVar2 = this.bsu.bst;
        if (aVar2 != null) {
            this.bsu.Vw();
            blackListModel = this.bsu.bsr;
            aVar3 = this.bsu.bst;
            blackListModel.removeFromBlackList(aVar3.getUserId());
        }
    }
}
