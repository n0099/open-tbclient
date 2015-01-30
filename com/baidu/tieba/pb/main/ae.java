package com.baidu.tieba.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bAT;
    private final /* synthetic */ db bAW;
    private final /* synthetic */ ShareFromPBMsgData bAX;
    private final /* synthetic */ long bou;
    private final /* synthetic */ String bov;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(PbActivity pbActivity, long j, String str, String str2, db dbVar, ShareFromPBMsgData shareFromPBMsgData) {
        this.bAT = pbActivity;
        this.bou = j;
        this.val$name = str;
        this.bov = str2;
        this.bAW = dbVar;
        this.bAX = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.bAT.getPageContext().getPageActivity(), this.bou, this.val$name, this.bov, 0, this.bAW.getLeaveMsg(), this.bAX.toChatMessageContent())));
        aVar.dismiss();
    }
}
