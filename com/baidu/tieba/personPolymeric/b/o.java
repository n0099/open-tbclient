package com.baidu.tieba.personPolymeric.b;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements a.b {
    final /* synthetic */ h ePZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(h hVar) {
        this.ePZ = hVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long j;
        BlackListModel blackListModel;
        BlackListModel blackListModel2;
        long j2;
        BlackListModel blackListModel3;
        long j3;
        j = this.ePZ.mUserId;
        if (j > 0) {
            blackListModel = this.ePZ.ePS;
            if (blackListModel.getMaskType() == 1) {
                blackListModel3 = this.ePZ.ePS;
                j3 = this.ePZ.mUserId;
                blackListModel3.removeFromBlackList(j3);
            } else {
                blackListModel2 = this.ePZ.ePS;
                j2 = this.ePZ.mUserId;
                blackListModel2.addToBlackList(j2);
            }
        }
        aVar.dismiss();
    }
}
