package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements a.b {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(f fVar) {
        this.this$0 = fVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        bf bfVar;
        BlackListModel blackListModel;
        BlackListModel blackListModel2;
        BlackListModel blackListModel3;
        bfVar = this.this$0.dvN;
        long c = com.baidu.adp.lib.h.b.c(bfVar.getId(), -1L);
        if (c > 0) {
            blackListModel = this.this$0.dCu;
            if (blackListModel.getMaskType() == 1) {
                blackListModel3 = this.this$0.dCu;
                blackListModel3.removeFromBlackList(c);
            } else {
                blackListModel2 = this.this$0.dCu;
                blackListModel2.addToBlackList(c);
            }
        }
        aVar.dismiss();
    }
}
