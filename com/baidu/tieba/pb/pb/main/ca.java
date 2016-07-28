package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements a.b {
    final /* synthetic */ PbActivity ebT;
    private final /* synthetic */ UserMuteAddAndDelCustomMessage ecg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(PbActivity pbActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
        this.ebT = pbActivity;
        this.ecg = userMuteAddAndDelCustomMessage;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        ew ewVar;
        ewVar = this.ebT.ebb;
        ewVar.atw();
        MessageManager.getInstance().sendMessage(this.ecg);
        aVar.dismiss();
    }
}
