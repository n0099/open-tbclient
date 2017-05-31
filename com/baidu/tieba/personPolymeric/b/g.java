package com.baidu.tieba.personPolymeric.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* loaded from: classes.dex */
class g implements a.b {
    final /* synthetic */ b eKV;
    private final /* synthetic */ UserMuteAddAndDelCustomMessage eyf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
        this.eKV = bVar;
        this.eyf = userMuteAddAndDelCustomMessage;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.eKV.Pd();
        MessageManager.getInstance().sendMessage(this.eyf);
        aVar.dismiss();
    }
}
