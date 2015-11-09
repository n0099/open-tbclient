package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(MainTabActivity mainTabActivity) {
        this.this$0 = mainTabActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.this$0.deR;
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
        }
    }
}
