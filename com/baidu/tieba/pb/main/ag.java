package com.baidu.tieba.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bAT;
    private final /* synthetic */ db bAW;
    private final /* synthetic */ ShareFromPBMsgData bAX;
    private final /* synthetic */ String bAY;
    private final /* synthetic */ int bAZ;
    private final /* synthetic */ int bkA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbActivity pbActivity, int i, String str, int i2, db dbVar, ShareFromPBMsgData shareFromPBMsgData) {
        this.bAT = pbActivity;
        this.bkA = i;
        this.bAY = str;
        this.bAZ = i2;
        this.bAW = dbVar;
        this.bAX = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.bAT.getPageContext().getPageActivity(), this.bkA, this.bAY, this.bAZ, "from_share", this.bAW.getLeaveMsg(), this.bAX.toChatMessageContent())));
        aVar.dismiss();
    }
}
