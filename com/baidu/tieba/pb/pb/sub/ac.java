package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements a.b {
    final /* synthetic */ NewSubPbActivity erC;
    private final /* synthetic */ UserMuteAddAndDelCustomMessage erD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(NewSubPbActivity newSubPbActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
        this.erC = newSubPbActivity;
        this.erD = userMuteAddAndDelCustomMessage;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ao aoVar;
        aoVar = this.erC.ern;
        aoVar.avh();
        MessageManager.getInstance().sendMessage(this.erD);
        aVar.dismiss();
    }
}
