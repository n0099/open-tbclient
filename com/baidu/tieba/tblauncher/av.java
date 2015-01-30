package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.d;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements d {
    private final /* synthetic */ a aRy;
    private final /* synthetic */ int aTX;
    final /* synthetic */ ai cdw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(ai aiVar, a aVar, int i) {
        this.cdw = aiVar;
        this.aRy = aVar;
        this.aTX = i;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        MainTabActivity mainTabActivity3;
        this.aRy.dismiss();
        MessageManager messageManager = MessageManager.getInstance();
        mainTabActivity = this.cdw.cdr;
        messageManager.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(mainTabActivity.getPageContext().getPageActivity(), 2)));
        if (this.aTX == 0) {
            mainTabActivity3 = this.cdw.cdr;
            TiebaStatic.eventStat(mainTabActivity3.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
        } else if (this.aTX == 1) {
            mainTabActivity2 = this.cdw.cdr;
            TiebaStatic.eventStat(mainTabActivity2.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
        }
    }
}
