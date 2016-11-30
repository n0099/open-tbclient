package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity dwY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.dwY = floatingPersonalChatActivity;
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
        userData = this.dwY.mUser;
        if (userData == null) {
            return;
        }
        floatingPersonalChatView = this.dwY.dwW;
        userData2 = this.dwY.mUser;
        String userName = userData2.getUserName();
        bVar = this.dwY.dtZ;
        floatingPersonalChatView.a(userName, bVar);
        j = this.dwY.dtY;
        if (j != 0) {
            handler = this.dwY.mHandler;
            runnable = this.dwY.dud;
            j2 = this.dwY.dtY;
            handler.postDelayed(runnable, j2);
        }
    }
}
