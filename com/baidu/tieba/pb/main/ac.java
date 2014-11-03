package com.baidu.tieba.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ long biv;
    private final /* synthetic */ String biw;
    final /* synthetic */ PbActivity bvu;
    private final /* synthetic */ cy bvx;
    private final /* synthetic */ ShareFromPBMsgData bvy;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(PbActivity pbActivity, long j, String str, String str2, cy cyVar, ShareFromPBMsgData shareFromPBMsgData) {
        this.bvu = pbActivity;
        this.biv = j;
        this.val$name = str;
        this.biw = str2;
        this.bvx = cyVar;
        this.bvy = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.bvu, this.biv, this.val$name, this.biw, 0, this.bvx.getLeaveMsg(), this.bvy.toChatMessageContent())));
        aVar.dismiss();
    }
}
