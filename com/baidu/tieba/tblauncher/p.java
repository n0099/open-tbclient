package com.baidu.tieba.tblauncher;

import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.AppUploadMessage;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(MainTabActivity mainTabActivity) {
        this.this$0 = mainTabActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        if (TbadkCoreApplication.m255getInst().isAppUploadOpen()) {
            MessageManager.getInstance().dispatchResponsedMessage(new AppUploadMessage());
            handler = this.this$0.mHandler;
            runnable = this.this$0.cdh;
            handler.postDelayed(runnable, 18000000L);
        }
    }
}
