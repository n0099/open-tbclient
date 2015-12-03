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
    private final /* synthetic */ int bas;
    private final /* synthetic */ String bat;
    private final /* synthetic */ long bau;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.net.a cys;
    private final /* synthetic */ PbChosenActivity cyt;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.m cyu;
    private final /* synthetic */ String cyv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(com.baidu.tieba.pb.chosen.net.a aVar, PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.m mVar, int i, String str, long j, String str2) {
        this.cys = aVar;
        this.cyt = pbChosenActivity;
        this.cyu = mVar;
        this.bas = i;
        this.bat = str;
        this.bau = j;
        this.cyv = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ShareFromPBMsgData a;
        if (this.cys != null && this.cys.getThreadInfo() != null) {
            com.baidu.adp.lib.util.k.c(this.cyt.getPageContext().getPageActivity(), this.cyu.getChatMsgView());
            Activity pageActivity = this.cyt.getPageContext().getPageActivity();
            int i = this.bas;
            String str = this.bat;
            long j = this.bau;
            String leaveMsg = this.cyu.getLeaveMsg();
            a = t.a(this.cys, this.cys.getThreadInfo().excid.longValue(), this.cyv);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(pageActivity, i, str, j, "from_share", leaveMsg, a.toChatMessageContent())));
            aVar.dismiss();
        }
    }
}
