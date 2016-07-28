package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements a.b {
    final /* synthetic */ h this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(h hVar) {
        this.this$0 = hVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        bn bnVar;
        BlackListModel blackListModel;
        BlackListModel blackListModel2;
        BlackListModel blackListModel3;
        bnVar = this.this$0.ers;
        long c = com.baidu.adp.lib.h.b.c(bnVar.getId(), -1L);
        if (c > 0) {
            blackListModel = this.this$0.eAv;
            if (blackListModel.getMaskType() == 1) {
                blackListModel3 = this.this$0.eAv;
                blackListModel3.removeFromBlackList(c);
            } else {
                blackListModel2 = this.this$0.eAv;
                blackListModel2.addToBlackList(c);
            }
        }
        aVar.dismiss();
    }
}
