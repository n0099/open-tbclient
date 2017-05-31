package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cj implements a.b {
    final /* synthetic */ PbActivity enc;
    private final /* synthetic */ UserMuteAddAndDelCustomMessage ens;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(PbActivity pbActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
        this.enc = pbActivity;
        this.ens = userMuteAddAndDelCustomMessage;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        fx fxVar;
        fxVar = this.enc.elU;
        fxVar.Pd();
        MessageManager.getInstance().sendMessage(this.ens);
        aVar.dismiss();
    }
}
