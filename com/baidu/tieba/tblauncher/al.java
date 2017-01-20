package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    final /* synthetic */ aa fuh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(aa aaVar) {
        this.fuh = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
            mainTabActivity = this.fuh.fua;
            mainTabActivity2 = this.fuh.fua;
            mainTabActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(mainTabActivity2.getPageContext().getPageActivity())));
            TiebaStatic.log("c10085");
        }
    }
}
