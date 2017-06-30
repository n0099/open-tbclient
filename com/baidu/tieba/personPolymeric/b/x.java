package com.baidu.tieba.personPolymeric.b;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements a.b {
    final /* synthetic */ r eVs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(r rVar) {
        this.eVs = rVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        BlackListModel blackListModel;
        BlackListModel blackListModel2;
        BlackListModel blackListModel3;
        if (this.eVs.mUserId > 0) {
            blackListModel = this.eVs.eVj;
            if (blackListModel.getMaskType() == 1) {
                blackListModel3 = this.eVs.eVj;
                blackListModel3.removeFromBlackList(this.eVs.mUserId);
            } else {
                blackListModel2 = this.eVs.eVj;
                blackListModel2.addToBlackList(this.eVs.mUserId);
            }
        }
        aVar.dismiss();
    }
}
