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
    private final /* synthetic */ long bKE;
    private final /* synthetic */ String bKF;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.net.a bZW;
    private final /* synthetic */ PbChosenActivity bZX;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.n bZY;
    private final /* synthetic */ String bZZ;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(com.baidu.tieba.pb.chosen.net.a aVar, PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.n nVar, long j, String str, String str2, String str3) {
        this.bZW = aVar;
        this.bZX = pbChosenActivity;
        this.bZY = nVar;
        this.bKE = j;
        this.val$name = str;
        this.bKF = str2;
        this.bZZ = str3;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ShareFromPBMsgData a;
        if (this.bZW != null && this.bZW.getForumInfo() != null) {
            com.baidu.adp.lib.util.k.c(this.bZX.getPageContext().getPageActivity(), this.bZY.getChatMsgView());
            Activity pageActivity = this.bZX.getPageContext().getPageActivity();
            long j = this.bKE;
            String str = this.val$name;
            String str2 = this.bKF;
            String leaveMsg = this.bZY.getLeaveMsg();
            a = r.a(this.bZW, this.bZW.getForumInfo().ftid.longValue(), this.bZZ);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(pageActivity, j, str, str2, 0, leaveMsg, a.toChatMessageContent())));
            aVar.dismiss();
        }
    }
}
