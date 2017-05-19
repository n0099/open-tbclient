package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements a.b {
    final /* synthetic */ NewSubPbActivity eqU;
    private final /* synthetic */ UserMuteAddAndDelCustomMessage eqV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(NewSubPbActivity newSubPbActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
        this.eqU = newSubPbActivity;
        this.eqV = userMuteAddAndDelCustomMessage;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ao aoVar;
        aoVar = this.eqU.eqF;
        aoVar.asr();
        MessageManager.getInstance().sendMessage(this.eqV);
        aVar.dismiss();
    }
}
