package com.baidu.tieba.personPolymeric.b;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements a.b {
    final /* synthetic */ h ety;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(h hVar) {
        this.ety = hVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        long j;
        BlackListModel blackListModel;
        BlackListModel blackListModel2;
        long j2;
        BlackListModel blackListModel3;
        long j3;
        j = this.ety.mUserId;
        if (j > 0) {
            blackListModel = this.ety.etq;
            if (blackListModel.getMaskType() == 1) {
                blackListModel3 = this.ety.etq;
                j3 = this.ety.mUserId;
                blackListModel3.removeFromBlackList(j3);
            } else {
                blackListModel2 = this.ety.etq;
                j2 = this.ety.mUserId;
                blackListModel2.addToBlackList(j2);
            }
        }
        aVar.dismiss();
    }
}
