package com.baidu.tieba.personPolymeric.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* loaded from: classes.dex */
class f implements a.b {
    private final /* synthetic */ UserMuteAddAndDelCustomMessage eit;
    final /* synthetic */ a etm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
        this.etm = aVar;
        this.eit = userMuteAddAndDelCustomMessage;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.etm.aub();
        MessageManager.getInstance().sendMessage(this.eit);
        aVar.dismiss();
    }
}
