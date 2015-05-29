package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ IMBlackListActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(IMBlackListActivity iMBlackListActivity) {
        this.bvg = iMBlackListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.im.data.a aVar2;
        BlackListModel blackListModel;
        com.baidu.tieba.im.data.a aVar3;
        aVar.rL();
        aVar2 = this.bvg.bvf;
        if (aVar2 != null) {
            this.bvg.WO();
            blackListModel = this.bvg.bvd;
            aVar3 = this.bvg.bvf;
            blackListModel.removeFromBlackList(aVar3.getUserId());
        }
    }
}
