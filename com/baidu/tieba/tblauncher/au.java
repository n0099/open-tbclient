package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements View.OnClickListener {
    final /* synthetic */ ao dfH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(ao aoVar) {
        this.dfH = aoVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.dfH.dfC;
        mainTabActivity2 = this.dfH.dfC;
        mainTabActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.SIGN_ALL_FORUM_CUSTOM_CMD, new SignAllForumActivityConfig(mainTabActivity2.getPageContext().getPageActivity())));
        TiebaStatic.log("c10085");
    }
}
