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
public class x implements a.b {
    private final /* synthetic */ int bBW;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.net.a bZc;
    private final /* synthetic */ PbChosenActivity bZd;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.n bZe;
    private final /* synthetic */ String bZf;
    private final /* synthetic */ String bZg;
    private final /* synthetic */ long bZh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(com.baidu.tieba.pb.chosen.net.a aVar, PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.n nVar, int i, String str, long j, String str2) {
        this.bZc = aVar;
        this.bZd = pbChosenActivity;
        this.bZe = nVar;
        this.bBW = i;
        this.bZg = str;
        this.bZh = j;
        this.bZf = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ShareFromPBMsgData a;
        if (this.bZc != null && this.bZc.getForumInfo() != null) {
            com.baidu.adp.lib.util.k.c(this.bZd.getPageContext().getPageActivity(), this.bZe.getChatMsgView());
            Activity pageActivity = this.bZd.getPageContext().getPageActivity();
            int i = this.bBW;
            String str = this.bZg;
            long j = this.bZh;
            String leaveMsg = this.bZe.getLeaveMsg();
            a = r.a(this.bZc, this.bZc.getForumInfo().ftid.longValue(), this.bZf);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(pageActivity, i, str, j, "from_share", leaveMsg, a.toChatMessageContent())));
            aVar.dismiss();
        }
    }
}
