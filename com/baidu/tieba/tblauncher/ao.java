package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ ai cdv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(ai aiVar) {
        this.cdv = aiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.cdv.cdq;
        mainTabActivity2 = this.cdv.cdq;
        mainTabActivity.sendMessage(new CustomMessage(2015002, new a(mainTabActivity2.getPageContext().getPageActivity())));
    }
}
