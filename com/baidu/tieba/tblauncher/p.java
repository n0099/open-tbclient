package com.baidu.tieba.tblauncher;

import android.content.DialogInterface;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.message.ExitAppMessage;
/* loaded from: classes.dex */
class p implements DialogInterface.OnClickListener {
    final /* synthetic */ MainTabActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tbadk.core.b.b.a(this.a, 12, false);
        MessageManager.getInstance().dispatchResponsedMessage(new ExitAppMessage());
    }
}
