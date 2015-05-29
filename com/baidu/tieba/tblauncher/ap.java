package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements View.OnClickListener {
    final /* synthetic */ aj cwn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(aj ajVar) {
        this.cwn = ajVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.cwn.cwh;
        mainTabActivity2 = this.cwn.cwh;
        mainTabActivity.sendMessage(new CustomMessage(2010030, new SignAllForumActivityConfig(mainTabActivity2.getPageContext().getPageActivity())));
    }
}
