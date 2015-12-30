package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity cfW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.cfW = floatingPersonalChatActivity;
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
        userData = this.cfW.mUser;
        if (userData == null) {
            return;
        }
        floatingPersonalChatView = this.cfW.cfU;
        userData2 = this.cfW.mUser;
        String userName = userData2.getUserName();
        bVar = this.cfW.ccX;
        floatingPersonalChatView.a(userName, bVar);
        j = this.cfW.ccW;
        if (j != 0) {
            handler = this.cfW.mHandler;
            runnable = this.cfW.cdb;
            j2 = this.cfW.ccW;
            handler.postDelayed(runnable, j2);
        }
    }
}
