package com.baidu.tieba.personInfo;

import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PersonInfoActivity bVf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PersonInfoActivity personInfoActivity) {
        this.bVf = personInfoActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        v vVar;
        BlackListModel blackListModel;
        BlackListModel blackListModel2;
        BlackListModel blackListModel3;
        vVar = this.bVf.bUU;
        int i = com.baidu.adp.lib.g.c.toInt(vVar.getId(), -1);
        if (i > 0) {
            blackListModel = this.bVf.bUT;
            if (blackListModel.getMaskType() == 1) {
                blackListModel3 = this.bVf.bUT;
                blackListModel3.removeFromBlackList(i);
            } else {
                blackListModel2 = this.bVf.bUT;
                blackListModel2.addToBlackList(i);
            }
        }
        aVar.dismiss();
    }
}
