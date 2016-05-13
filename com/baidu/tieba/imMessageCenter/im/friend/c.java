package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    final /* synthetic */ IMBlackListActivity cww;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(IMBlackListActivity iMBlackListActivity) {
        this.cww = iMBlackListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.im.data.a aVar2;
        BlackListModel blackListModel;
        com.baidu.tieba.im.data.a aVar3;
        aVar.rV();
        aVar2 = this.cww.cwv;
        if (aVar2 != null) {
            this.cww.akx();
            blackListModel = this.cww.cwt;
            aVar3 = this.cww.cwv;
            blackListModel.removeFromBlackList(aVar3.getUserId());
        }
    }
}
