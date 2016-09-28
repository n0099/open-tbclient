package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements a.b {
    final /* synthetic */ NewSubPbActivity exF;
    private final /* synthetic */ UserMuteAddAndDelCustomMessage exG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(NewSubPbActivity newSubPbActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
        this.exF = newSubPbActivity;
        this.exG = userMuteAddAndDelCustomMessage;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ag agVar;
        agVar = this.exF.exu;
        agVar.ayI();
        MessageManager.getInstance().sendMessage(this.exG);
        aVar.dismiss();
    }
}
