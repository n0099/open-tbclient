package com.baidu.tieba.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ long bmX;
    private final /* synthetic */ String bmY;
    final /* synthetic */ PbActivity bzj;
    private final /* synthetic */ dc bzm;
    private final /* synthetic */ ShareFromPBMsgData bzn;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbActivity pbActivity, long j, String str, String str2, dc dcVar, ShareFromPBMsgData shareFromPBMsgData) {
        this.bzj = pbActivity;
        this.bmX = j;
        this.val$name = str;
        this.bmY = str2;
        this.bzm = dcVar;
        this.bzn = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.bzj.getPageContext().getPageActivity(), this.bmX, this.val$name, this.bmY, 0, this.bzm.getLeaveMsg(), this.bzn.toChatMessageContent())));
        aVar.dismiss();
    }
}
