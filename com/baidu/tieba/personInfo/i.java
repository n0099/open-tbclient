package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.b {
    final /* synthetic */ PersonInfoActivity csI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PersonInfoActivity personInfoActivity) {
        this.csI = personInfoActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        y yVar;
        BlackListModel blackListModel;
        BlackListModel blackListModel2;
        BlackListModel blackListModel3;
        yVar = this.csI.csv;
        long c = com.baidu.adp.lib.g.b.c(yVar.getId(), -1L);
        if (c > 0) {
            blackListModel = this.csI.csu;
            if (blackListModel.getMaskType() == 1) {
                blackListModel3 = this.csI.csu;
                blackListModel3.removeFromBlackList(c);
            } else {
                blackListModel2 = this.csI.csu;
                blackListModel2.addToBlackList(c);
            }
        }
        aVar.dismiss();
    }
}
