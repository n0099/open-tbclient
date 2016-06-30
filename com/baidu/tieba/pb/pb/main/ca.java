package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements a.b {
    final /* synthetic */ PbActivity dPF;
    private final /* synthetic */ UserMuteAddAndDelCustomMessage dPS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(PbActivity pbActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
        this.dPF = pbActivity;
        this.dPS = userMuteAddAndDelCustomMessage;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        es esVar;
        esVar = this.dPF.dOO;
        esVar.asK();
        MessageManager.getInstance().sendMessage(this.dPS);
        aVar.dismiss();
    }
}
