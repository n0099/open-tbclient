package com.baidu.tieba.personInfo;

import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PersonInfoActivity bIm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PersonInfoActivity personInfoActivity) {
        this.bIm = personInfoActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        v vVar;
        BlackListModel blackListModel;
        BlackListModel blackListModel2;
        BlackListModel blackListModel3;
        vVar = this.bIm.bIb;
        int i = com.baidu.adp.lib.g.c.toInt(vVar.getId(), -1);
        if (i > 0) {
            blackListModel = this.bIm.bIa;
            if (blackListModel.getMaskType() == 1) {
                blackListModel3 = this.bIm.bIa;
                blackListModel3.removeFromBlackList(i);
            } else {
                blackListModel2 = this.bIm.bIa;
                blackListModel2.addToBlackList(i);
            }
        }
        aVar.dismiss();
    }
}
