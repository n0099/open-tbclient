package com.baidu.tieba.tblauncher;

import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.message.AppUploadMessage;
/* loaded from: classes.dex */
class ab implements Runnable {
    final /* synthetic */ MainTabActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        if (TbadkApplication.m252getInst().isAppUploadOpen()) {
            MessageManager.getInstance().dispatchResponsedMessage(new AppUploadMessage());
            handler = this.a.T;
            runnable = this.a.X;
            handler.postDelayed(runnable, 18000000L);
        }
    }
}
