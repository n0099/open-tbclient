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
    private final /* synthetic */ int aUX;
    private final /* synthetic */ String aUY;
    private final /* synthetic */ long aUZ;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.net.a cfp;
    private final /* synthetic */ PbChosenActivity cfq;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.n cfr;
    private final /* synthetic */ String cfs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(com.baidu.tieba.pb.chosen.net.a aVar, PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.n nVar, int i, String str, long j, String str2) {
        this.cfp = aVar;
        this.cfq = pbChosenActivity;
        this.cfr = nVar;
        this.aUX = i;
        this.aUY = str;
        this.aUZ = j;
        this.cfs = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ShareFromPBMsgData a;
        if (this.cfp != null && this.cfp.getForumInfo() != null) {
            com.baidu.adp.lib.util.k.c(this.cfq.getPageContext().getPageActivity(), this.cfr.getChatMsgView());
            Activity pageActivity = this.cfq.getPageContext().getPageActivity();
            int i = this.aUX;
            String str = this.aUY;
            long j = this.aUZ;
            String leaveMsg = this.cfr.getLeaveMsg();
            a = s.a(this.cfp, this.cfp.getForumInfo().ftid.longValue(), this.cfs);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(pageActivity, i, str, j, "from_share", leaveMsg, a.toChatMessageContent())));
            aVar.dismiss();
        }
    }
}
