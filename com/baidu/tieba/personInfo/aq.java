package com.baidu.tieba.personInfo;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.im.model.BlackListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements a.b {
    final /* synthetic */ d cWV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(d dVar) {
        this.cWV = dVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        bb bbVar;
        BlackListModel blackListModel;
        BlackListModel blackListModel2;
        BlackListModel blackListModel3;
        bbVar = this.cWV.cRx;
        long c = com.baidu.adp.lib.h.b.c(bbVar.getId(), -1L);
        if (c > 0) {
            blackListModel = this.cWV.cWj;
            if (blackListModel.getMaskType() == 1) {
                blackListModel3 = this.cWV.cWj;
                blackListModel3.removeFromBlackList(c);
            } else {
                blackListModel2 = this.cWV.cWj;
                blackListModel2.addToBlackList(c);
            }
        }
        aVar.dismiss();
    }
}
