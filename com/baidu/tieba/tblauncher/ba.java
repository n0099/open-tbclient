package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aDi;
    private final /* synthetic */ int bbB;
    final /* synthetic */ aj cwo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(aj ajVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.cwo = ajVar;
        this.aDi = aVar;
        this.bbB = i;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        MainTabActivity mainTabActivity3;
        this.aDi.dismiss();
        MessageManager messageManager = MessageManager.getInstance();
        mainTabActivity = this.cwo.cwi;
        messageManager.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(mainTabActivity.getPageContext().getPageActivity(), 2)));
        if (this.bbB == 0) {
            mainTabActivity3 = this.cwo.cwi;
            TiebaStatic.eventStat(mainTabActivity3.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
        } else if (this.bbB == 1) {
            mainTabActivity2 = this.cwo.cwi;
            TiebaStatic.eventStat(mainTabActivity2.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
        }
    }
}
