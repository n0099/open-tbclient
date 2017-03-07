package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements a.b {
    final /* synthetic */ PbActivity elO;
    private final /* synthetic */ UserMuteAddAndDelCustomMessage eme;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(PbActivity pbActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
        this.elO = pbActivity;
        this.eme = userMuteAddAndDelCustomMessage;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        fa faVar;
        faVar = this.elO.ekM;
        faVar.auC();
        MessageManager.getInstance().sendMessage(this.eme);
        aVar.dismiss();
    }
}
