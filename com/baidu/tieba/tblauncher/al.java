package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a arp;
    private final /* synthetic */ int cHo;
    final /* synthetic */ ad flb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ad adVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.flb = adVar;
        this.arp = aVar;
        this.cHo = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        MainTabActivity mainTabActivity3;
        this.arp.dismiss();
        String str = null;
        if (this.cHo == 0) {
            str = "4006001000";
            mainTabActivity3 = this.flb.fkU;
            TiebaStatic.eventStat(mainTabActivity3.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
        } else if (this.cHo == 1) {
            str = "4005001000";
            mainTabActivity = this.flb.fkU;
            TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
        }
        mainTabActivity2 = this.flb.fkU;
        MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(mainTabActivity2.getPageContext().getPageActivity(), 2);
        if (!StringUtils.isNULL(str)) {
            memberPayActivityConfig.setSceneId(str);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
    }
}
