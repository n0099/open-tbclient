package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements a.b {
    final /* synthetic */ PbActivity eqa;
    private final /* synthetic */ UserMuteAddAndDelCustomMessage eqn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(PbActivity pbActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
        this.eqa = pbActivity;
        this.eqn = userMuteAddAndDelCustomMessage;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ex exVar;
        exVar = this.eqa.epe;
        exVar.ayI();
        MessageManager.getInstance().sendMessage(this.eqn);
        aVar.dismiss();
    }
}
