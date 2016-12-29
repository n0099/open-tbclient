package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements a.b {
    final /* synthetic */ PbActivity eah;
    private final /* synthetic */ UserMuteAddAndDelCustomMessage eax;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(PbActivity pbActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
        this.eah = pbActivity;
        this.eax = userMuteAddAndDelCustomMessage;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        er erVar;
        erVar = this.eah.dZk;
        erVar.aub();
        MessageManager.getInstance().sendMessage(this.eax);
        aVar.dismiss();
    }
}
