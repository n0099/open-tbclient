package com.baidu.tieba.pb.chosen;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements a.b {
    private final /* synthetic */ int beq;
    private final /* synthetic */ String ber;
    private final /* synthetic */ long bes;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.net.a cBZ;
    private final /* synthetic */ PbChosenActivity cCa;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.m cCb;
    private final /* synthetic */ String cCc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(com.baidu.tieba.pb.chosen.net.a aVar, PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.m mVar, int i, String str, long j, String str2) {
        this.cBZ = aVar;
        this.cCa = pbChosenActivity;
        this.cCb = mVar;
        this.beq = i;
        this.ber = str;
        this.bes = j;
        this.cCc = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ShareFromPBMsgData a;
        if (this.cBZ != null && this.cBZ.getThreadInfo() != null) {
            com.baidu.adp.lib.util.k.c(this.cCa.getPageContext().getPageActivity(), this.cCb.getChatMsgView());
            Activity pageActivity = this.cCa.getPageContext().getPageActivity();
            int i = this.beq;
            String str = this.ber;
            long j = this.bes;
            String leaveMsg = this.cCb.getLeaveMsg();
            a = t.a(this.cBZ, this.cBZ.getThreadInfo().excid.longValue(), this.cCc);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(pageActivity, i, str, j, "from_share", leaveMsg, a.toChatMessageContent())));
            aVar.dismiss();
        }
    }
}
