package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cb implements a.b {
    final /* synthetic */ PbActivity ejU;
    private final /* synthetic */ UserMuteAddAndDelCustomMessage ekk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(PbActivity pbActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
        this.ejU = pbActivity;
        this.ekk = userMuteAddAndDelCustomMessage;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ey eyVar;
        eyVar = this.ejU.eiS;
        eyVar.auv();
        MessageManager.getInstance().sendMessage(this.ekk);
        aVar.dismiss();
    }
}
