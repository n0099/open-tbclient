package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ aj cwo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(aj ajVar) {
        this.cwo = ajVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.cwo.cwi;
        mainTabActivity2 = this.cwo.cwi;
        mainTabActivity.sendMessage(new CustomMessage(2015003, new com.baidu.tbadk.core.frameworkData.c(mainTabActivity2.getPageContext().getPageActivity())));
    }
}
