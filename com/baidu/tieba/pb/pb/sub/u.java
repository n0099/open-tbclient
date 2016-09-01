package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements a.b {
    final /* synthetic */ NewSubPbActivity evy;
    private final /* synthetic */ UserMuteAddAndDelCustomMessage evz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(NewSubPbActivity newSubPbActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
        this.evy = newSubPbActivity;
        this.evz = userMuteAddAndDelCustomMessage;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ag agVar;
        agVar = this.evy.evn;
        agVar.ayk();
        MessageManager.getInstance().sendMessage(this.evz);
        aVar.dismiss();
    }
}
