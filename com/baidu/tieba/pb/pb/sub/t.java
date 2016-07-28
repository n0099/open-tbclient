package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements a.b {
    final /* synthetic */ NewSubPbActivity ejr;
    private final /* synthetic */ UserMuteAddAndDelCustomMessage ejs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(NewSubPbActivity newSubPbActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
        this.ejr = newSubPbActivity;
        this.ejs = userMuteAddAndDelCustomMessage;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        af afVar;
        afVar = this.ejr.ejg;
        afVar.atw();
        MessageManager.getInstance().sendMessage(this.ejs);
        aVar.dismiss();
    }
}
