package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ IMBlackListActivity bvh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(IMBlackListActivity iMBlackListActivity) {
        this.bvh = iMBlackListActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.im.data.a aVar2;
        BlackListModel blackListModel;
        com.baidu.tieba.im.data.a aVar3;
        aVar.rL();
        aVar2 = this.bvh.bvg;
        if (aVar2 != null) {
            this.bvh.WP();
            blackListModel = this.bvh.bve;
            aVar3 = this.bvh.bvg;
            blackListModel.removeFromBlackList(aVar3.getUserId());
        }
    }
}
