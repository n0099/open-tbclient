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
    private final /* synthetic */ long aUU;
    private final /* synthetic */ String aUV;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.net.a cfp;
    private final /* synthetic */ PbChosenActivity cfq;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.n cfr;
    private final /* synthetic */ String cfs;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(com.baidu.tieba.pb.chosen.net.a aVar, PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.n nVar, long j, String str, String str2, String str3) {
        this.cfp = aVar;
        this.cfq = pbChosenActivity;
        this.cfr = nVar;
        this.aUU = j;
        this.val$name = str;
        this.aUV = str2;
        this.cfs = str3;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ShareFromPBMsgData a;
        if (this.cfp != null && this.cfp.getForumInfo() != null) {
            com.baidu.adp.lib.util.k.c(this.cfq.getPageContext().getPageActivity(), this.cfr.getChatMsgView());
            Activity pageActivity = this.cfq.getPageContext().getPageActivity();
            long j = this.aUU;
            String str = this.val$name;
            String str2 = this.aUV;
            String leaveMsg = this.cfr.getLeaveMsg();
            a = s.a(this.cfp, this.cfp.getForumInfo().ftid.longValue(), this.cfs);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(pageActivity, j, str, str2, 0, leaveMsg, a.toChatMessageContent())));
            aVar.dismiss();
        }
    }
}
