package com.baidu.tieba.pb.chosen;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements a.b {
    private final /* synthetic */ long ben;
    private final /* synthetic */ String beo;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.net.a cBZ;
    private final /* synthetic */ PbChosenActivity cCa;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.m cCb;
    private final /* synthetic */ String cCc;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(com.baidu.tieba.pb.chosen.net.a aVar, PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.m mVar, long j, String str, String str2, String str3) {
        this.cBZ = aVar;
        this.cCa = pbChosenActivity;
        this.cCb = mVar;
        this.ben = j;
        this.val$name = str;
        this.beo = str2;
        this.cCc = str3;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ShareFromPBMsgData a;
        if (this.cBZ != null && this.cBZ.getThreadInfo() != null) {
            com.baidu.adp.lib.util.k.c(this.cCa.getPageContext().getPageActivity(), this.cCb.getChatMsgView());
            Activity pageActivity = this.cCa.getPageContext().getPageActivity();
            long j = this.ben;
            String str = this.val$name;
            String str2 = this.beo;
            String leaveMsg = this.cCb.getLeaveMsg();
            a = t.a(this.cBZ, this.cBZ.getThreadInfo().excid.longValue(), this.cCc);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(pageActivity, j, str, str2, 0, leaveMsg, a.toChatMessageContent())));
            aVar.dismiss();
        }
    }
}
