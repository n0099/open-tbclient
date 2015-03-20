package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ IMBlackListActivity bse;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(IMBlackListActivity iMBlackListActivity) {
        this.bse = iMBlackListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.im.data.a aVar2;
        BlackListModel blackListModel;
        com.baidu.tieba.im.data.a aVar3;
        aVar.re();
        aVar2 = this.bse.bsd;
        if (aVar2 != null) {
            this.bse.Vj();
            blackListModel = this.bse.bsb;
            aVar3 = this.bse.bsd;
            blackListModel.removeFromBlackList(aVar3.getUserId());
        }
    }
}
