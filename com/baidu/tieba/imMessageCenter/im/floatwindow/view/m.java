package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity bMm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.bMm = floatingPersonalChatActivity;
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
        userData = this.bMm.mUser;
        if (userData == null) {
            return;
        }
        floatingPersonalChatView = this.bMm.bMk;
        userData2 = this.bMm.mUser;
        String userName = userData2.getUserName();
        bVar = this.bMm.bJm;
        floatingPersonalChatView.a(userName, bVar);
        j = this.bMm.bJl;
        if (j != 0) {
            handler = this.bMm.mHandler;
            runnable = this.bMm.bJq;
            j2 = this.bMm.bJl;
            handler.postDelayed(runnable, j2);
        }
    }
}
