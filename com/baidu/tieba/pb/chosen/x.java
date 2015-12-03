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
public class x implements a.b {
    private final /* synthetic */ long bao;
    private final /* synthetic */ String bap;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.net.a cys;
    private final /* synthetic */ PbChosenActivity cyt;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.m cyu;
    private final /* synthetic */ String cyv;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(com.baidu.tieba.pb.chosen.net.a aVar, PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.m mVar, long j, String str, String str2, String str3) {
        this.cys = aVar;
        this.cyt = pbChosenActivity;
        this.cyu = mVar;
        this.bao = j;
        this.val$name = str;
        this.bap = str2;
        this.cyv = str3;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ShareFromPBMsgData a;
        if (this.cys != null && this.cys.getThreadInfo() != null) {
            com.baidu.adp.lib.util.k.c(this.cyt.getPageContext().getPageActivity(), this.cyu.getChatMsgView());
            Activity pageActivity = this.cyt.getPageContext().getPageActivity();
            long j = this.bao;
            String str = this.val$name;
            String str2 = this.bap;
            String leaveMsg = this.cyu.getLeaveMsg();
            a = t.a(this.cys, this.cys.getThreadInfo().excid.longValue(), this.cyv);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(pageActivity, j, str, str2, 0, leaveMsg, a.toChatMessageContent())));
            aVar.dismiss();
        }
    }
}
