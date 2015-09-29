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
    private final /* synthetic */ int aUM;
    private final /* synthetic */ String aUN;
    private final /* synthetic */ long aUO;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.net.a cfe;
    private final /* synthetic */ PbChosenActivity cff;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.n cfg;
    private final /* synthetic */ String cfh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(com.baidu.tieba.pb.chosen.net.a aVar, PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.n nVar, int i, String str, long j, String str2) {
        this.cfe = aVar;
        this.cff = pbChosenActivity;
        this.cfg = nVar;
        this.aUM = i;
        this.aUN = str;
        this.aUO = j;
        this.cfh = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ShareFromPBMsgData a;
        if (this.cfe != null && this.cfe.getForumInfo() != null) {
            com.baidu.adp.lib.util.k.c(this.cff.getPageContext().getPageActivity(), this.cfg.getChatMsgView());
            Activity pageActivity = this.cff.getPageContext().getPageActivity();
            int i = this.aUM;
            String str = this.aUN;
            long j = this.aUO;
            String leaveMsg = this.cfg.getLeaveMsg();
            a = s.a(this.cfe, this.cfe.getForumInfo().ftid.longValue(), this.cfh);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(pageActivity, i, str, j, "from_share", leaveMsg, a.toChatMessageContent())));
            aVar.dismiss();
        }
    }
}
