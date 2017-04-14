package com.baidu.tieba.personPolymeric.b;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements a.b {
    final /* synthetic */ h eEQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(h hVar) {
        this.eEQ = hVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long j;
        BlackListModel blackListModel;
        BlackListModel blackListModel2;
        long j2;
        BlackListModel blackListModel3;
        long j3;
        j = this.eEQ.mUserId;
        if (j > 0) {
            blackListModel = this.eEQ.eEI;
            if (blackListModel.getMaskType() == 1) {
                blackListModel3 = this.eEQ.eEI;
                j3 = this.eEQ.mUserId;
                blackListModel3.removeFromBlackList(j3);
            } else {
                blackListModel2 = this.eEQ.eEI;
                j2 = this.eEQ.mUserId;
                blackListModel2.addToBlackList(j2);
            }
        }
        aVar.dismiss();
    }
}
