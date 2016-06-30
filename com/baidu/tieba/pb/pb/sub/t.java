package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements a.b {
    final /* synthetic */ NewSubPbActivity dWP;
    private final /* synthetic */ UserMuteAddAndDelCustomMessage dWQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(NewSubPbActivity newSubPbActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
        this.dWP = newSubPbActivity;
        this.dWQ = userMuteAddAndDelCustomMessage;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        af afVar;
        afVar = this.dWP.dWE;
        afVar.asK();
        MessageManager.getInstance().sendMessage(this.dWQ);
        aVar.dismiss();
    }
}
