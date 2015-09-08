package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity bJh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.bJh = floatingPersonalChatActivity;
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
        userData = this.bJh.mUser;
        if (userData == null) {
            return;
        }
        floatingPersonalChatView = this.bJh.bJf;
        userData2 = this.bJh.mUser;
        String userName = userData2.getUserName();
        bVar = this.bJh.bGh;
        floatingPersonalChatView.a(userName, bVar);
        j = this.bJh.bGg;
        if (j != 0) {
            handler = this.bJh.mHandler;
            runnable = this.bJh.bGl;
            j2 = this.bJh.bGg;
            handler.postDelayed(runnable, j2);
        }
    }
}
