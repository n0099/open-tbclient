package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(MainTabActivity mainTabActivity) {
        this.this$0 = mainTabActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2 = this.this$0;
        mainTabActivity = this.this$0.bPd;
        mainTabActivity2.sendMessage(new CustomMessage(2015002, new com.baidu.tbadk.core.frameworkData.a(mainTabActivity)));
    }
}
