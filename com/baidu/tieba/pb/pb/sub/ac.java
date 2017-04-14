package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements a.b {
    final /* synthetic */ NewSubPbActivity esV;
    private final /* synthetic */ UserMuteAddAndDelCustomMessage esW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(NewSubPbActivity newSubPbActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
        this.esV = newSubPbActivity;
        this.esW = userMuteAddAndDelCustomMessage;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ao aoVar;
        aoVar = this.esV.esG;
        aoVar.auv();
        MessageManager.getInstance().sendMessage(this.esW);
        aVar.dismiss();
    }
}
