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
public class ar implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a awm;
    final /* synthetic */ ah fzg;
    private final /* synthetic */ int val$type;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ah ahVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.fzg = ahVar;
        this.awm = aVar;
        this.val$type = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        MainTabActivity mainTabActivity3;
        this.awm.dismiss();
        String str = null;
        if (this.val$type == 0) {
            str = "4006001000";
            mainTabActivity3 = this.fzg.fyW;
            TiebaStatic.eventStat(mainTabActivity3.getPageContext().getPageActivity(), "user_overdue_pay", "click", 1, new Object[0]);
        } else if (this.val$type == 1) {
            str = "4005001000";
            mainTabActivity = this.fzg.fyW;
            TiebaStatic.eventStat(mainTabActivity.getPageContext().getPageActivity(), "user_expire_pay", "click", 1, new Object[0]);
        }
        mainTabActivity2 = this.fzg.fyW;
        MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(mainTabActivity2.getPageContext().getPageActivity(), 2);
        if (!StringUtils.isNULL(str)) {
            memberPayActivityConfig.setSceneId(str);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
    }
}
