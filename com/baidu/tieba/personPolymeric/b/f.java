package com.baidu.tieba.personPolymeric.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* loaded from: classes.dex */
class f implements a.b {
    final /* synthetic */ a eJp;
    private final /* synthetic */ UserMuteAddAndDelCustomMessage exG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
        this.eJp = aVar;
        this.exG = userMuteAddAndDelCustomMessage;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.eJp.ayI();
        MessageManager.getInstance().sendMessage(this.exG);
        aVar.dismiss();
    }
}
