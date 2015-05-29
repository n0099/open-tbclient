package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ aj cwn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(aj ajVar) {
        this.cwn = ajVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.cwn.cwh;
        mainTabActivity2 = this.cwn.cwh;
        mainTabActivity.sendMessage(new CustomMessage(2015003, new com.baidu.tbadk.core.frameworkData.c(mainTabActivity2.getPageContext().getPageActivity())));
    }
}
