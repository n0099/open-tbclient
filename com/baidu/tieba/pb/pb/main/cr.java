package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cr implements a.b {
    final /* synthetic */ PbActivity ewh;
    private final /* synthetic */ UserMuteAddAndDelCustomMessage ewx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(PbActivity pbActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
        this.ewh = pbActivity;
        this.ewx = userMuteAddAndDelCustomMessage;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        gg ggVar;
        ggVar = this.ewh.euU;
        ggVar.Qx();
        MessageManager.getInstance().sendMessage(this.ewx);
        aVar.dismiss();
    }
}
