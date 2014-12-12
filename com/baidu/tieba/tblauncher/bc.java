package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ int aSL;
    final /* synthetic */ an ccc;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a cce;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(an anVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.ccc = anVar;
        this.cce = aVar;
        this.aSL = i;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        MainTabActivity mainTabActivity3;
        this.cce.dismiss();
        MessageManager messageManager = MessageManager.getInstance();
        mainTabActivity = this.ccc.cbW;
        messageManager.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(mainTabActivity.getPageContext().getPageActivity(), 2)));
        if (this.aSL == 0) {
            mainTabActivity3 = this.ccc.cbW;
            TiebaStatic.eventStat(mainTabActivity3.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
        } else if (this.aSL == 1) {
            mainTabActivity2 = this.ccc.cbW;
            TiebaStatic.eventStat(mainTabActivity2.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
        }
    }
}
