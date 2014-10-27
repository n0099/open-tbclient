package com.baidu.tieba.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ int bfD;
    final /* synthetic */ PbActivity bvg;
    private final /* synthetic */ cy bvj;
    private final /* synthetic */ ShareFromPBMsgData bvk;
    private final /* synthetic */ String bvl;
    private final /* synthetic */ int bvm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(PbActivity pbActivity, int i, String str, int i2, cy cyVar, ShareFromPBMsgData shareFromPBMsgData) {
        this.bvg = pbActivity;
        this.bfD = i;
        this.bvl = str;
        this.bvm = i2;
        this.bvj = cyVar;
        this.bvk = shareFromPBMsgData;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.bvg, this.bfD, this.bvl, this.bvm, "from_share", this.bvj.getLeaveMsg(), this.bvk.toChatMessageContent())));
        aVar.dismiss();
    }
}
