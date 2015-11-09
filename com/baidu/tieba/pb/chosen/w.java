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
public class w implements a.b {
    private final /* synthetic */ long aVc;
    private final /* synthetic */ String aVd;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.net.a cfQ;
    private final /* synthetic */ PbChosenActivity cfR;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.n cfS;
    private final /* synthetic */ String cfT;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(com.baidu.tieba.pb.chosen.net.a aVar, PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.n nVar, long j, String str, String str2, String str3) {
        this.cfQ = aVar;
        this.cfR = pbChosenActivity;
        this.cfS = nVar;
        this.aVc = j;
        this.val$name = str;
        this.aVd = str2;
        this.cfT = str3;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ShareFromPBMsgData a;
        if (this.cfQ != null && this.cfQ.getForumInfo() != null) {
            com.baidu.adp.lib.util.k.c(this.cfR.getPageContext().getPageActivity(), this.cfS.getChatMsgView());
            Activity pageActivity = this.cfR.getPageContext().getPageActivity();
            long j = this.aVc;
            String str = this.val$name;
            String str2 = this.aVd;
            String leaveMsg = this.cfS.getLeaveMsg();
            a = s.a(this.cfQ, this.cfQ.getForumInfo().ftid.longValue(), this.cfT);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(pageActivity, j, str, str2, 0, leaveMsg, a.toChatMessageContent())));
            aVar.dismiss();
        }
    }
}
