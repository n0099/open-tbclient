package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity cbW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.cbW = floatingPersonalChatActivity;
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
        userData = this.cbW.mUser;
        if (userData == null) {
            return;
        }
        floatingPersonalChatView = this.cbW.cbU;
        userData2 = this.cbW.mUser;
        String userName = userData2.getUserName();
        bVar = this.cbW.bYX;
        floatingPersonalChatView.a(userName, bVar);
        j = this.cbW.bYW;
        if (j != 0) {
            handler = this.cbW.mHandler;
            runnable = this.cbW.bZb;
            j2 = this.cbW.bYW;
            handler.postDelayed(runnable, j2);
        }
    }
}
