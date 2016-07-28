package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity dem;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.dem = floatingPersonalChatActivity;
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
        userData = this.dem.mUser;
        if (userData == null) {
            return;
        }
        floatingPersonalChatView = this.dem.dek;
        userData2 = this.dem.mUser;
        String userName = userData2.getUserName();
        bVar = this.dem.dbl;
        floatingPersonalChatView.a(userName, bVar);
        j = this.dem.dbk;
        if (j != 0) {
            handler = this.dem.mHandler;
            runnable = this.dem.dbp;
            j2 = this.dem.dbk;
            handler.postDelayed(runnable, j2);
        }
    }
}
