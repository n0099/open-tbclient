package com.baidu.tieba.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ int bjd;
    final /* synthetic */ PbActivity bzj;
    private final /* synthetic */ dc bzm;
    private final /* synthetic */ ShareFromPBMsgData bzn;
    private final /* synthetic */ String bzo;
    private final /* synthetic */ int bzp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbActivity pbActivity, int i, String str, int i2, dc dcVar, ShareFromPBMsgData shareFromPBMsgData) {
        this.bzj = pbActivity;
        this.bjd = i;
        this.bzo = str;
        this.bzp = i2;
        this.bzm = dcVar;
        this.bzn = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.bzj.getPageContext().getPageActivity(), this.bjd, this.bzo, this.bzp, "from_share", this.bzm.getLeaveMsg(), this.bzn.toChatMessageContent())));
        aVar.dismiss();
    }
}
