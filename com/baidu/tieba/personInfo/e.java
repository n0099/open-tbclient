package com.baidu.tieba.personInfo;

import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PersonInfoActivity bVe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PersonInfoActivity personInfoActivity) {
        this.bVe = personInfoActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        v vVar;
        BlackListModel blackListModel;
        BlackListModel blackListModel2;
        BlackListModel blackListModel3;
        vVar = this.bVe.bUT;
        int i = com.baidu.adp.lib.g.c.toInt(vVar.getId(), -1);
        if (i > 0) {
            blackListModel = this.bVe.bUS;
            if (blackListModel.getMaskType() == 1) {
                blackListModel3 = this.bVe.bUS;
                blackListModel3.removeFromBlackList(i);
            } else {
                blackListModel2 = this.bVe.bUS;
                blackListModel2.addToBlackList(i);
            }
        }
        aVar.dismiss();
    }
}
