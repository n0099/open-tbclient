package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements a.b {
    final /* synthetic */ PersonInfoActivity clO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PersonInfoActivity personInfoActivity) {
        this.clO = personInfoActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        w wVar;
        BlackListModel blackListModel;
        BlackListModel blackListModel2;
        BlackListModel blackListModel3;
        wVar = this.clO.clC;
        long c = com.baidu.adp.lib.g.b.c(wVar.getId(), -1L);
        if (c > 0) {
            blackListModel = this.clO.clB;
            if (blackListModel.getMaskType() == 1) {
                blackListModel3 = this.clO.clB;
                blackListModel3.removeFromBlackList(c);
            } else {
                blackListModel2 = this.clO.clB;
                blackListModel2.addToBlackList(c);
            }
        }
        aVar.dismiss();
    }
}
