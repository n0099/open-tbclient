package com.baidu.tieba.pb.chosen;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ com.baidu.tieba.pb.chosen.net.a bJf;
    private final /* synthetic */ PbChosenActivity bJg;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.l bJh;
    private final /* synthetic */ String bJi;
    private final /* synthetic */ long bwh;
    private final /* synthetic */ String bwi;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(com.baidu.tieba.pb.chosen.net.a aVar, PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.l lVar, long j, String str, String str2, String str3) {
        this.bJf = aVar;
        this.bJg = pbChosenActivity;
        this.bJh = lVar;
        this.bwh = j;
        this.val$name = str;
        this.bwi = str2;
        this.bJi = str3;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ShareFromPBMsgData a;
        if (this.bJf != null && this.bJf.getForumInfo() != null) {
            com.baidu.adp.lib.util.n.c(this.bJg.getPageContext().getPageActivity(), this.bJh.getChatMsgView());
            Activity pageActivity = this.bJg.getPageContext().getPageActivity();
            long j = this.bwh;
            String str = this.val$name;
            String str2 = this.bwi;
            String leaveMsg = this.bJh.getLeaveMsg();
            a = h.a(this.bJf, this.bJf.getForumInfo().ftid.longValue(), this.bJi);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(pageActivity, j, str, str2, 0, leaveMsg, a.toChatMessageContent())));
            aVar.dismiss();
        }
    }
}
