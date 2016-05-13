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
public class aq implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a amF;
    private final /* synthetic */ int cbw;
    final /* synthetic */ ab exg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ab abVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.exg = abVar;
        this.amF = aVar;
        this.cbw = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        MainTabActivity mainTabActivity3;
        this.amF.dismiss();
        String str = null;
        if (this.cbw == 0) {
            str = "4006001000";
            mainTabActivity3 = this.exg.ewR;
            TiebaStatic.eventStat(mainTabActivity3.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
        } else if (this.cbw == 1) {
            str = "4005001000";
            mainTabActivity = this.exg.ewR;
            TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
        }
        mainTabActivity2 = this.exg.ewR;
        MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(mainTabActivity2.getPageContext().getPageActivity(), 2);
        if (!StringUtils.isNULL(str)) {
            memberPayActivityConfig.setSceneId(str);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
    }
}
