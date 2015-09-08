package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements a.b {
    final /* synthetic */ PersonInfoActivity cmR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PersonInfoActivity personInfoActivity) {
        this.cmR = personInfoActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        w wVar;
        BlackListModel blackListModel;
        BlackListModel blackListModel2;
        BlackListModel blackListModel3;
        wVar = this.cmR.cmF;
        long c = com.baidu.adp.lib.g.b.c(wVar.getId(), -1L);
        if (c > 0) {
            blackListModel = this.cmR.cmE;
            if (blackListModel.getMaskType() == 1) {
                blackListModel3 = this.cmR.cmE;
                blackListModel3.removeFromBlackList(c);
            } else {
                blackListModel2 = this.cmR.cmE;
                blackListModel2.addToBlackList(c);
            }
        }
        aVar.dismiss();
    }
}
