package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements View.OnClickListener {
    final /* synthetic */ an ccc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(an anVar) {
        this.ccc = anVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.ccc.cbW;
        mainTabActivity2 = this.ccc.cbW;
        mainTabActivity.sendMessage(new CustomMessage(2015002, new com.baidu.tbadk.core.frameworkData.a(mainTabActivity2.getPageContext().getPageActivity())));
    }
}
