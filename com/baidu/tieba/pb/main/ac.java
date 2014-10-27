package com.baidu.tieba.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ long bih;
    private final /* synthetic */ String bii;
    final /* synthetic */ PbActivity bvg;
    private final /* synthetic */ cy bvj;
    private final /* synthetic */ ShareFromPBMsgData bvk;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(PbActivity pbActivity, long j, String str, String str2, cy cyVar, ShareFromPBMsgData shareFromPBMsgData) {
        this.bvg = pbActivity;
        this.bih = j;
        this.val$name = str;
        this.bii = str2;
        this.bvj = cyVar;
        this.bvk = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.bvg, this.bih, this.val$name, this.bii, 0, this.bvj.getLeaveMsg(), this.bvk.toChatMessageContent())));
        aVar.dismiss();
    }
}
