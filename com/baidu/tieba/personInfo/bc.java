package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements a.b {
    private final /* synthetic */ UserMuteAddAndDelCustomMessage dWQ;
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(f fVar, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
        this.this$0 = fVar;
        this.dWQ = userMuteAddAndDelCustomMessage;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.this$0.asK();
        MessageManager.getInstance().sendMessage(this.dWQ);
        aVar.dismiss();
    }
}
