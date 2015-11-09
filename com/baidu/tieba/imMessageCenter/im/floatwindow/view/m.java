package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity bMS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.bMS = floatingPersonalChatActivity;
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
        userData = this.bMS.mUser;
        if (userData == null) {
            return;
        }
        floatingPersonalChatView = this.bMS.bMQ;
        userData2 = this.bMS.mUser;
        String userName = userData2.getUserName();
        bVar = this.bMS.bJS;
        floatingPersonalChatView.a(userName, bVar);
        j = this.bMS.bJR;
        if (j != 0) {
            handler = this.bMS.mHandler;
            runnable = this.bMS.bJW;
            j2 = this.bMS.bJR;
            handler.postDelayed(runnable, j2);
        }
    }
}
