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
public class z implements a.b {
    private final /* synthetic */ int bgL;
    private final /* synthetic */ String bgM;
    private final /* synthetic */ long bgN;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.net.a cIE;
    private final /* synthetic */ PbChosenActivity cIF;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.m cIG;
    private final /* synthetic */ String cIH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(com.baidu.tieba.pb.chosen.net.a aVar, PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.m mVar, int i, String str, long j, String str2) {
        this.cIE = aVar;
        this.cIF = pbChosenActivity;
        this.cIG = mVar;
        this.bgL = i;
        this.bgM = str;
        this.bgN = j;
        this.cIH = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        ShareFromPBMsgData a;
        if (this.cIE != null && this.cIE.getThreadInfo() != null) {
            com.baidu.adp.lib.util.k.c(this.cIF.getPageContext().getPageActivity(), this.cIG.getChatMsgView());
            Activity pageActivity = this.cIF.getPageContext().getPageActivity();
            int i = this.bgL;
            String str = this.bgM;
            long j = this.bgN;
            String leaveMsg = this.cIG.getLeaveMsg();
            a = t.a(this.cIE, this.cIE.getThreadInfo().excid.longValue(), this.cIH);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(pageActivity, i, str, j, "from_share", leaveMsg, a.toChatMessageContent())));
            aVar.dismiss();
        }
    }
}
