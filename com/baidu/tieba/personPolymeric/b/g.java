package com.baidu.tieba.personPolymeric.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* loaded from: classes.dex */
class g implements a.b {
    private final /* synthetic */ UserMuteAddAndDelCustomMessage eHD;
    final /* synthetic */ b eUU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
        this.eUU = bVar;
        this.eHD = userMuteAddAndDelCustomMessage;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.eUU.Qx();
        MessageManager.getInstance().sendMessage(this.eHD);
        aVar.dismiss();
    }
}
