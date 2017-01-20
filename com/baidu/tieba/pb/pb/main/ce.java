package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements a.b {
    final /* synthetic */ PbActivity eiV;
    private final /* synthetic */ UserMuteAddAndDelCustomMessage ejm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(PbActivity pbActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
        this.eiV = pbActivity;
        this.ejm = userMuteAddAndDelCustomMessage;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ez ezVar;
        ezVar = this.eiV.ehV;
        ezVar.avh();
        MessageManager.getInstance().sendMessage(this.ejm);
        aVar.dismiss();
    }
}
