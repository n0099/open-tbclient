package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements a.b {
    private final /* synthetic */ UserMuteAddAndDelCustomMessage ejs;
    final /* synthetic */ h this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(h hVar, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
        this.this$0 = hVar;
        this.ejs = userMuteAddAndDelCustomMessage;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.this$0.atw();
        MessageManager.getInstance().sendMessage(this.ejs);
        aVar.dismiss();
    }
}
