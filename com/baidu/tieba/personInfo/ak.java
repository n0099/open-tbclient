package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements a.b {
    final /* synthetic */ d cSn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(d dVar) {
        this.cSn = dVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aw awVar;
        BlackListModel blackListModel;
        BlackListModel blackListModel2;
        BlackListModel blackListModel3;
        awVar = this.cSn.cMT;
        long c = com.baidu.adp.lib.h.b.c(awVar.getId(), -1L);
        if (c > 0) {
            blackListModel = this.cSn.cRI;
            if (blackListModel.getMaskType() == 1) {
                blackListModel3 = this.cSn.cRI;
                blackListModel3.removeFromBlackList(c);
            } else {
                blackListModel2 = this.cSn.cRI;
                blackListModel2.addToBlackList(c);
            }
        }
        aVar.dismiss();
    }
}
