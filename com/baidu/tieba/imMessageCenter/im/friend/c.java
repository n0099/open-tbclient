package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    final /* synthetic */ IMBlackListActivity bNp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(IMBlackListActivity iMBlackListActivity) {
        this.bNp = iMBlackListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.im.data.a aVar2;
        BlackListModel blackListModel;
        com.baidu.tieba.im.data.a aVar3;
        aVar.sR();
        aVar2 = this.bNp.bNo;
        if (aVar2 != null) {
            this.bNp.Zw();
            blackListModel = this.bNp.bNm;
            aVar3 = this.bNp.bNo;
            blackListModel.removeFromBlackList(aVar3.getUserId());
        }
    }
}
