package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ ai csd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(ai aiVar) {
        this.csd = aiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.csd.crX;
        mainTabActivity2 = this.csd.crX;
        mainTabActivity.sendMessage(new CustomMessage(2015002, new com.baidu.tbadk.core.frameworkData.a(mainTabActivity2.getPageContext().getPageActivity())));
    }
}
