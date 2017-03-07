package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements a.b {
    final /* synthetic */ NewSubPbActivity euQ;
    private final /* synthetic */ UserMuteAddAndDelCustomMessage euR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(NewSubPbActivity newSubPbActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
        this.euQ = newSubPbActivity;
        this.euR = userMuteAddAndDelCustomMessage;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ao aoVar;
        aoVar = this.euQ.euB;
        aoVar.auC();
        MessageManager.getInstance().sendMessage(this.euR);
        aVar.dismiss();
    }
}
