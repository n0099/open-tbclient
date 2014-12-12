package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MyLiveActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements View.OnClickListener {
    final /* synthetic */ an ccc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(an anVar) {
        this.ccc = anVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        this.ccc.aiX();
        mainTabActivity = this.ccc.cbW;
        mainTabActivity2 = this.ccc.cbW;
        mainTabActivity.sendMessage(new CustomMessage(2002001, new MyLiveActivityConfig(mainTabActivity2.getPageContext().getPageActivity())));
    }
}
