package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements a.b {
    final /* synthetic */ f diG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(f fVar) {
        this.diG = fVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        bf bfVar;
        BlackListModel blackListModel;
        BlackListModel blackListModel2;
        BlackListModel blackListModel3;
        bfVar = this.diG.dbl;
        long c = com.baidu.adp.lib.h.b.c(bfVar.getId(), -1L);
        if (c > 0) {
            blackListModel = this.diG.dhS;
            if (blackListModel.getMaskType() == 1) {
                blackListModel3 = this.diG.dhS;
                blackListModel3.removeFromBlackList(c);
            } else {
                blackListModel2 = this.diG.dhS;
                blackListModel2.addToBlackList(c);
            }
        }
        aVar.dismiss();
    }
}
