package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    final /* synthetic */ IMBlackListActivity cvz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(IMBlackListActivity iMBlackListActivity) {
        this.cvz = iMBlackListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.im.data.a aVar2;
        BlackListModel blackListModel;
        com.baidu.tieba.im.data.a aVar3;
        aVar.up();
        aVar2 = this.cvz.cvy;
        if (aVar2 != null) {
            this.cvz.akp();
            blackListModel = this.cvz.cvw;
            aVar3 = this.cvz.cvy;
            blackListModel.removeFromBlackList(aVar3.getUserId());
        }
    }
}
