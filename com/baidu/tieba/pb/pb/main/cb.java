package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cb implements a.b {
    private final /* synthetic */ UserMuteAddAndDelCustomMessage emA;
    final /* synthetic */ PbActivity emk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(PbActivity pbActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
        this.emk = pbActivity;
        this.emA = userMuteAddAndDelCustomMessage;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ey eyVar;
        eyVar = this.emk.eli;
        eyVar.avw();
        MessageManager.getInstance().sendMessage(this.emA);
        aVar.dismiss();
    }
}
