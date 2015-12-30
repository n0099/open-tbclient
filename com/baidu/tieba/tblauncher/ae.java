package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a apI;
    private final /* synthetic */ int bMx;
    final /* synthetic */ w dKW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(w wVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.dKW = wVar;
        this.apI = aVar;
        this.bMx = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        MainTabActivity mainTabActivity3;
        this.apI.dismiss();
        MessageManager messageManager = MessageManager.getInstance();
        mainTabActivity = this.dKW.dKM;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(mainTabActivity.getPageContext().getPageActivity(), 2)));
        if (this.bMx == 0) {
            mainTabActivity3 = this.dKW.dKM;
            TiebaStatic.eventStat(mainTabActivity3.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
        } else if (this.bMx == 1) {
            mainTabActivity2 = this.dKW.dKM;
            TiebaStatic.eventStat(mainTabActivity2.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
        }
    }
}
