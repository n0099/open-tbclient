package com.baidu.tieba.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bAS;
    private final /* synthetic */ db bAV;
    private final /* synthetic */ ShareFromPBMsgData bAW;
    private final /* synthetic */ String bAX;
    private final /* synthetic */ int bAY;
    private final /* synthetic */ int bkz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbActivity pbActivity, int i, String str, int i2, db dbVar, ShareFromPBMsgData shareFromPBMsgData) {
        this.bAS = pbActivity;
        this.bkz = i;
        this.bAX = str;
        this.bAY = i2;
        this.bAV = dbVar;
        this.bAW = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.bAS.getPageContext().getPageActivity(), this.bkz, this.bAX, this.bAY, "from_share", this.bAV.getLeaveMsg(), this.bAW.toChatMessageContent())));
        aVar.dismiss();
    }
}
