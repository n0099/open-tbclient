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
    private final /* synthetic */ long aUJ;
    private final /* synthetic */ String aUK;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.net.a cfe;
    private final /* synthetic */ PbChosenActivity cff;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.n cfg;
    private final /* synthetic */ String cfh;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(com.baidu.tieba.pb.chosen.net.a aVar, PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.n nVar, long j, String str, String str2, String str3) {
        this.cfe = aVar;
        this.cff = pbChosenActivity;
        this.cfg = nVar;
        this.aUJ = j;
        this.val$name = str;
        this.aUK = str2;
        this.cfh = str3;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ShareFromPBMsgData a;
        if (this.cfe != null && this.cfe.getForumInfo() != null) {
            com.baidu.adp.lib.util.k.c(this.cff.getPageContext().getPageActivity(), this.cfg.getChatMsgView());
            Activity pageActivity = this.cff.getPageContext().getPageActivity();
            long j = this.aUJ;
            String str = this.val$name;
            String str2 = this.aUK;
            String leaveMsg = this.cfg.getLeaveMsg();
            a = s.a(this.cfe, this.cfe.getForumInfo().ftid.longValue(), this.cfh);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(pageActivity, j, str, str2, 0, leaveMsg, a.toChatMessageContent())));
            aVar.dismiss();
        }
    }
}
