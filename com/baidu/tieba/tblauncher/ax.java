package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aBl;
    private final /* synthetic */ int aYD;
    final /* synthetic */ ai crN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(ai aiVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.crN = aiVar;
        this.aBl = aVar;
        this.aYD = i;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        MainTabActivity mainTabActivity3;
        this.aBl.dismiss();
        MessageManager messageManager = MessageManager.getInstance();
        mainTabActivity = this.crN.crH;
        messageManager.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(mainTabActivity.getPageContext().getPageActivity(), 2)));
        if (this.aYD == 0) {
            mainTabActivity3 = this.crN.crH;
            TiebaStatic.eventStat(mainTabActivity3.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
        } else if (this.aYD == 1) {
            mainTabActivity2 = this.crN.crH;
            TiebaStatic.eventStat(mainTabActivity2.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
        }
    }
}
