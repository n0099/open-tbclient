package com.baidu.tieba.pb.chosen;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ com.baidu.tieba.pb.chosen.net.a bJe;
    private final /* synthetic */ PbChosenActivity bJf;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.l bJg;
    private final /* synthetic */ String bJh;
    private final /* synthetic */ long bwg;
    private final /* synthetic */ String bwh;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(com.baidu.tieba.pb.chosen.net.a aVar, PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.l lVar, long j, String str, String str2, String str3) {
        this.bJe = aVar;
        this.bJf = pbChosenActivity;
        this.bJg = lVar;
        this.bwg = j;
        this.val$name = str;
        this.bwh = str2;
        this.bJh = str3;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ShareFromPBMsgData a;
        if (this.bJe != null && this.bJe.getForumInfo() != null) {
            com.baidu.adp.lib.util.n.c(this.bJf.getPageContext().getPageActivity(), this.bJg.getChatMsgView());
            Activity pageActivity = this.bJf.getPageContext().getPageActivity();
            long j = this.bwg;
            String str = this.val$name;
            String str2 = this.bwh;
            String leaveMsg = this.bJg.getLeaveMsg();
            a = h.a(this.bJe, this.bJe.getForumInfo().ftid.longValue(), this.bJh);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(pageActivity, j, str, str2, 0, leaveMsg, a.toChatMessageContent())));
            aVar.dismiss();
        }
    }
}
