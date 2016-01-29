package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    final /* synthetic */ y ebe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(y yVar) {
        this.ebe = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.ebe.eaS;
        mainTabActivity2 = this.ebe.eaS;
        mainTabActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.SIGN_ALL_FORUM_CUSTOM_CMD, new SignAllForumActivityConfig(mainTabActivity2.getPageContext().getPageActivity())));
        TiebaStatic.log("c10085");
    }
}
