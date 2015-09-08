package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aKS;
    private final /* synthetic */ int bpU;
    final /* synthetic */ am cVq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(am amVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.cVq = amVar;
        this.aKS = aVar;
        this.bpU = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        MainTabActivity mainTabActivity3;
        this.aKS.dismiss();
        MessageManager messageManager = MessageManager.getInstance();
        mainTabActivity = this.cVq.cVl;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(mainTabActivity.getPageContext().getPageActivity(), 2)));
        if (this.bpU == 0) {
            mainTabActivity3 = this.cVq.cVl;
            TiebaStatic.eventStat(mainTabActivity3.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
        } else if (this.bpU == 1) {
            mainTabActivity2 = this.cVq.cVl;
            TiebaStatic.eventStat(mainTabActivity2.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
        }
    }
}
