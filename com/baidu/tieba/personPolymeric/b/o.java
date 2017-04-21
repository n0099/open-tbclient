package com.baidu.tieba.personPolymeric.b;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements a.b {
    final /* synthetic */ h eHg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(h hVar) {
        this.eHg = hVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long j;
        BlackListModel blackListModel;
        BlackListModel blackListModel2;
        long j2;
        BlackListModel blackListModel3;
        long j3;
        j = this.eHg.mUserId;
        if (j > 0) {
            blackListModel = this.eHg.eGY;
            if (blackListModel.getMaskType() == 1) {
                blackListModel3 = this.eHg.eGY;
                j3 = this.eHg.mUserId;
                blackListModel3.removeFromBlackList(j3);
            } else {
                blackListModel2 = this.eHg.eGY;
                j2 = this.eHg.mUserId;
                blackListModel2.addToBlackList(j2);
            }
        }
        aVar.dismiss();
    }
}
