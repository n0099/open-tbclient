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
public class ap implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a anl;
    private final /* synthetic */ int cGS;
    final /* synthetic */ ab fbT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ab abVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.fbT = abVar;
        this.anl = aVar;
        this.cGS = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        MainTabActivity mainTabActivity3;
        this.anl.dismiss();
        String str = null;
        if (this.cGS == 0) {
            str = "4006001000";
            mainTabActivity3 = this.fbT.fbI;
            TiebaStatic.eventStat(mainTabActivity3.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
        } else if (this.cGS == 1) {
            str = "4005001000";
            mainTabActivity = this.fbT.fbI;
            TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
        }
        mainTabActivity2 = this.fbT.fbI;
        MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(mainTabActivity2.getPageContext().getPageActivity(), 2);
        if (!StringUtils.isNULL(str)) {
            memberPayActivityConfig.setSceneId(str);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
    }
}
