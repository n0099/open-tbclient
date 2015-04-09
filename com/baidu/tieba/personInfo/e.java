package com.baidu.tieba.personInfo;

import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PersonInfoActivity bSx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PersonInfoActivity personInfoActivity) {
        this.bSx = personInfoActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        v vVar;
        BlackListModel blackListModel;
        BlackListModel blackListModel2;
        BlackListModel blackListModel3;
        vVar = this.bSx.bSm;
        int i = com.baidu.adp.lib.g.c.toInt(vVar.getId(), -1);
        if (i > 0) {
            blackListModel = this.bSx.bSl;
            if (blackListModel.getMaskType() == 1) {
                blackListModel3 = this.bSx.bSl;
                blackListModel3.removeFromBlackList(i);
            } else {
                blackListModel2 = this.bSx.bSl;
                blackListModel2.addToBlackList(i);
            }
        }
        aVar.dismiss();
    }
}
