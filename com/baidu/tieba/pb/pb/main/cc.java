package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements a.b {
    final /* synthetic */ PbActivity eob;
    private final /* synthetic */ UserMuteAddAndDelCustomMessage eop;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(PbActivity pbActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
        this.eob = pbActivity;
        this.eop = userMuteAddAndDelCustomMessage;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ex exVar;
        exVar = this.eob.enh;
        exVar.ayk();
        MessageManager.getInstance().sendMessage(this.eop);
        aVar.dismiss();
    }
}
