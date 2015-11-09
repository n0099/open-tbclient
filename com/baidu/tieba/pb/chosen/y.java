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
public class y implements a.b {
    private final /* synthetic */ int aVf;
    private final /* synthetic */ String aVg;
    private final /* synthetic */ long aVh;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.net.a cfQ;
    private final /* synthetic */ PbChosenActivity cfR;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.n cfS;
    private final /* synthetic */ String cfT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(com.baidu.tieba.pb.chosen.net.a aVar, PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.n nVar, int i, String str, long j, String str2) {
        this.cfQ = aVar;
        this.cfR = pbChosenActivity;
        this.cfS = nVar;
        this.aVf = i;
        this.aVg = str;
        this.aVh = j;
        this.cfT = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ShareFromPBMsgData a;
        if (this.cfQ != null && this.cfQ.getForumInfo() != null) {
            com.baidu.adp.lib.util.k.c(this.cfR.getPageContext().getPageActivity(), this.cfS.getChatMsgView());
            Activity pageActivity = this.cfR.getPageContext().getPageActivity();
            int i = this.aVf;
            String str = this.aVg;
            long j = this.aVh;
            String leaveMsg = this.cfS.getLeaveMsg();
            a = s.a(this.cfQ, this.cfQ.getForumInfo().ftid.longValue(), this.cfT);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(pageActivity, i, str, j, "from_share", leaveMsg, a.toChatMessageContent())));
            aVar.dismiss();
        }
    }
}
