package com.baidu.tieba.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ int bfR;
    private final /* synthetic */ int bvA;
    final /* synthetic */ PbActivity bvu;
    private final /* synthetic */ cy bvx;
    private final /* synthetic */ ShareFromPBMsgData bvy;
    private final /* synthetic */ String bvz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(PbActivity pbActivity, int i, String str, int i2, cy cyVar, ShareFromPBMsgData shareFromPBMsgData) {
        this.bvu = pbActivity;
        this.bfR = i;
        this.bvz = str;
        this.bvA = i2;
        this.bvx = cyVar;
        this.bvy = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.bvu, this.bfR, this.bvz, this.bvA, "from_share", this.bvx.getLeaveMsg(), this.bvy.toChatMessageContent())));
        aVar.dismiss();
    }
}
