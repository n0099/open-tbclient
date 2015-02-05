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
    private final /* synthetic */ a aRx;
    private final /* synthetic */ int aTW;
    final /* synthetic */ ai cdv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(ai aiVar, a aVar, int i) {
        this.cdv = aiVar;
        this.aRx = aVar;
        this.aTW = i;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        MainTabActivity mainTabActivity3;
        this.aRx.dismiss();
        MessageManager messageManager = MessageManager.getInstance();
        mainTabActivity = this.cdv.cdq;
        messageManager.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(mainTabActivity.getPageContext().getPageActivity(), 2)));
        if (this.aTW == 0) {
            mainTabActivity3 = this.cdv.cdq;
            TiebaStatic.eventStat(mainTabActivity3.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
        } else if (this.aTW == 1) {
            mainTabActivity2 = this.cdv.cdq;
            TiebaStatic.eventStat(mainTabActivity2.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
        }
    }
}
