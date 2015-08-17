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
public class v implements a.b {
    private final /* synthetic */ long bJX;
    private final /* synthetic */ String bJY;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.net.a bZc;
    private final /* synthetic */ PbChosenActivity bZd;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.n bZe;
    private final /* synthetic */ String bZf;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(com.baidu.tieba.pb.chosen.net.a aVar, PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.n nVar, long j, String str, String str2, String str3) {
        this.bZc = aVar;
        this.bZd = pbChosenActivity;
        this.bZe = nVar;
        this.bJX = j;
        this.val$name = str;
        this.bJY = str2;
        this.bZf = str3;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ShareFromPBMsgData a;
        if (this.bZc != null && this.bZc.getForumInfo() != null) {
            com.baidu.adp.lib.util.k.c(this.bZd.getPageContext().getPageActivity(), this.bZe.getChatMsgView());
            Activity pageActivity = this.bZd.getPageContext().getPageActivity();
            long j = this.bJX;
            String str = this.val$name;
            String str2 = this.bJY;
            String leaveMsg = this.bZe.getLeaveMsg();
            a = r.a(this.bZc, this.bZc.getForumInfo().ftid.longValue(), this.bZf);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(pageActivity, j, str, str2, 0, leaveMsg, a.toChatMessageContent())));
            aVar.dismiss();
        }
    }
}
