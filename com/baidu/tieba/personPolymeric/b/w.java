package com.baidu.tieba.personPolymeric.b;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements a.b {
    final /* synthetic */ p eLo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(p pVar) {
        this.eLo = pVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        BlackListModel blackListModel;
        BlackListModel blackListModel2;
        BlackListModel blackListModel3;
        if (this.eLo.mUserId > 0) {
            blackListModel = this.eLo.eLh;
            if (blackListModel.getMaskType() == 1) {
                blackListModel3 = this.eLo.eLh;
                blackListModel3.removeFromBlackList(this.eLo.mUserId);
            } else {
                blackListModel2 = this.eLo.eLh;
                blackListModel2.addToBlackList(this.eLo.mUserId);
            }
        }
        aVar.dismiss();
    }
}
