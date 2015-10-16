package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity bMx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.bMx = floatingPersonalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        UserData userData;
        FloatingPersonalChatView floatingPersonalChatView;
        UserData userData2;
        com.baidu.tbadk.coreExtra.relationship.b bVar;
        long j;
        Handler handler;
        Runnable runnable;
        long j2;
        userData = this.bMx.mUser;
        if (userData == null) {
            return;
        }
        floatingPersonalChatView = this.bMx.bMv;
        userData2 = this.bMx.mUser;
        String userName = userData2.getUserName();
        bVar = this.bMx.bJx;
        floatingPersonalChatView.a(userName, bVar);
        j = this.bMx.bJw;
        if (j != 0) {
            handler = this.bMx.mHandler;
            runnable = this.bMx.bJB;
            j2 = this.bMx.bJw;
            handler.postDelayed(runnable, j2);
        }
    }
}
