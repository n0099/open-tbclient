package com.baidu.tieba.pb.chosen;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.data.ShareFromPBMsgData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ com.baidu.tieba.pb.chosen.net.a bJe;
    private final /* synthetic */ PbChosenActivity bJf;
    private final /* synthetic */ com.baidu.tieba.pb.chosen.a.l bJg;
    private final /* synthetic */ String bJh;
    private final /* synthetic */ String bJi;
    private final /* synthetic */ int bJj;
    private final /* synthetic */ int boi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(com.baidu.tieba.pb.chosen.net.a aVar, PbChosenActivity pbChosenActivity, com.baidu.tieba.pb.chosen.a.l lVar, int i, String str, int i2, String str2) {
        this.bJe = aVar;
        this.bJf = pbChosenActivity;
        this.bJg = lVar;
        this.boi = i;
        this.bJi = str;
        this.bJj = i2;
        this.bJh = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ShareFromPBMsgData a;
        if (this.bJe != null && this.bJe.getForumInfo() != null) {
            com.baidu.adp.lib.util.n.c(this.bJf.getPageContext().getPageActivity(), this.bJg.getChatMsgView());
            String leaveMsg = this.bJg.getLeaveMsg();
            a = h.a(this.bJe, this.bJe.getForumInfo().ftid.longValue(), this.bJh);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.bJf.getPageContext().getPageActivity(), this.boi, this.bJi, this.bJj, "from_share", leaveMsg, a.toChatMessageContent())));
            aVar.dismiss();
        }
    }
}
