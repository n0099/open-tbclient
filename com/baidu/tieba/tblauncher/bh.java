package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a amr;
    private final /* synthetic */ int btK;
    final /* synthetic */ ao dfH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(ao aoVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.dfH = aoVar;
        this.amr = aVar;
        this.btK = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        MainTabActivity mainTabActivity3;
        this.amr.dismiss();
        MessageManager messageManager = MessageManager.getInstance();
        mainTabActivity = this.dfH.dfC;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(mainTabActivity.getPageContext().getPageActivity(), 2)));
        if (this.btK == 0) {
            mainTabActivity3 = this.dfH.dfC;
            TiebaStatic.eventStat(mainTabActivity3.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
        } else if (this.btK == 1) {
            mainTabActivity2 = this.dfH.dfC;
            TiebaStatic.eventStat(mainTabActivity2.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
        }
    }
}
