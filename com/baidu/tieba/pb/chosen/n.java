package com.baidu.tieba.pb.chosen;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ com.baidu.tieba.pb.chosen.net.a bJf;
    private final /* synthetic */ PbChosenActivity bJg;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.l bJh;
    private final /* synthetic */ String bJi;
    private final /* synthetic */ String bJj;
    private final /* synthetic */ int bJk;
    private final /* synthetic */ int boj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(com.baidu.tieba.pb.chosen.net.a aVar, PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.l lVar, int i, String str, int i2, String str2) {
        this.bJf = aVar;
        this.bJg = pbChosenActivity;
        this.bJh = lVar;
        this.boj = i;
        this.bJj = str;
        this.bJk = i2;
        this.bJi = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ShareFromPBMsgData a;
        if (this.bJf != null && this.bJf.getForumInfo() != null) {
            com.baidu.adp.lib.util.n.c(this.bJg.getPageContext().getPageActivity(), this.bJh.getChatMsgView());
            String leaveMsg = this.bJh.getLeaveMsg();
            a = h.a(this.bJf, this.bJf.getForumInfo().ftid.longValue(), this.bJi);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.bJg.getPageContext().getPageActivity(), this.boj, this.bJj, this.bJk, "from_share", leaveMsg, a.toChatMessageContent())));
            aVar.dismiss();
        }
    }
}
