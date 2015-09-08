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
    private final /* synthetic */ int bCD;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.net.a bZW;
    private final /* synthetic */ PbChosenActivity bZX;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.n bZY;
    private final /* synthetic */ String bZZ;
    private final /* synthetic */ String caa;
    private final /* synthetic */ long cab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(com.baidu.tieba.pb.chosen.net.a aVar, PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.n nVar, int i, String str, long j, String str2) {
        this.bZW = aVar;
        this.bZX = pbChosenActivity;
        this.bZY = nVar;
        this.bCD = i;
        this.caa = str;
        this.cab = j;
        this.bZZ = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ShareFromPBMsgData a;
        if (this.bZW != null && this.bZW.getForumInfo() != null) {
            com.baidu.adp.lib.util.k.c(this.bZX.getPageContext().getPageActivity(), this.bZY.getChatMsgView());
            Activity pageActivity = this.bZX.getPageContext().getPageActivity();
            int i = this.bCD;
            String str = this.caa;
            long j = this.cab;
            String leaveMsg = this.bZY.getLeaveMsg();
            a = r.a(this.bZW, this.bZW.getForumInfo().ftid.longValue(), this.bZZ);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(pageActivity, i, str, j, "from_share", leaveMsg, a.toChatMessageContent())));
            aVar.dismiss();
        }
    }
}
