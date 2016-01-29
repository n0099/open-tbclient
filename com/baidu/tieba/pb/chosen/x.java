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
    private final /* synthetic */ long bgI;
    private final /* synthetic */ String bgJ;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.net.a cIE;
    private final /* synthetic */ PbChosenActivity cIF;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.m cIG;
    private final /* synthetic */ String cIH;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(com.baidu.tieba.pb.chosen.net.a aVar, PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.m mVar, long j, String str, String str2, String str3) {
        this.cIE = aVar;
        this.cIF = pbChosenActivity;
        this.cIG = mVar;
        this.bgI = j;
        this.val$name = str;
        this.bgJ = str2;
        this.cIH = str3;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        ShareFromPBMsgData a;
        if (this.cIE != null && this.cIE.getThreadInfo() != null) {
            com.baidu.adp.lib.util.k.c(this.cIF.getPageContext().getPageActivity(), this.cIG.getChatMsgView());
            Activity pageActivity = this.cIF.getPageContext().getPageActivity();
            long j = this.bgI;
            String str = this.val$name;
            String str2 = this.bgJ;
            String leaveMsg = this.cIG.getLeaveMsg();
            a = t.a(this.cIE, this.cIE.getThreadInfo().excid.longValue(), this.cIH);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(pageActivity, j, str, str2, 0, leaveMsg, a.toChatMessageContent())));
            aVar.dismiss();
        }
    }
}
