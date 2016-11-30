package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements a.b {
    final /* synthetic */ PbActivity evL;
    private final /* synthetic */ UserMuteAddAndDelCustomMessage ewb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(PbActivity pbActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
        this.evL = pbActivity;
        this.ewb = userMuteAddAndDelCustomMessage;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ey eyVar;
        eyVar = this.evL.euP;
        eyVar.aAF();
        MessageManager.getInstance().sendMessage(this.ewb);
        aVar.dismiss();
    }
}
