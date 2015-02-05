package com.baidu.tieba.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bAS;
    private final /* synthetic */ db bAV;
    private final /* synthetic */ ShareFromPBMsgData bAW;
    private final /* synthetic */ long bot;
    private final /* synthetic */ String bou;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(PbActivity pbActivity, long j, String str, String str2, db dbVar, ShareFromPBMsgData shareFromPBMsgData) {
        this.bAS = pbActivity;
        this.bot = j;
        this.val$name = str;
        this.bou = str2;
        this.bAV = dbVar;
        this.bAW = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.bAS.getPageContext().getPageActivity(), this.bot, this.val$name, this.bou, 0, this.bAV.getLeaveMsg(), this.bAW.toChatMessageContent())));
        aVar.dismiss();
    }
}
