package com.baidu.tieba.personPolymeric.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* loaded from: classes.dex */
class f implements a.b {
    private final /* synthetic */ UserMuteAddAndDelCustomMessage eEt;
    final /* synthetic */ a ePO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
        this.ePO = aVar;
        this.eEt = userMuteAddAndDelCustomMessage;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.ePO.aAF();
        MessageManager.getInstance().sendMessage(this.eEt);
        aVar.dismiss();
    }
}
