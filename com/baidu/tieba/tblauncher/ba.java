package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aDh;
    private final /* synthetic */ int bbA;
    final /* synthetic */ aj cwn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(aj ajVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.cwn = ajVar;
        this.aDh = aVar;
        this.bbA = i;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        MainTabActivity mainTabActivity3;
        this.aDh.dismiss();
        MessageManager messageManager = MessageManager.getInstance();
        mainTabActivity = this.cwn.cwh;
        messageManager.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(mainTabActivity.getPageContext().getPageActivity(), 2)));
        if (this.bbA == 0) {
            mainTabActivity3 = this.cwn.cwh;
            TiebaStatic.eventStat(mainTabActivity3.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
        } else if (this.bbA == 1) {
            mainTabActivity2 = this.cwn.cwh;
            TiebaStatic.eventStat(mainTabActivity2.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
        }
    }
}
