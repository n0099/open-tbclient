package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity dbp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.dbp = floatingPersonalChatActivity;
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
        userData = this.dbp.mUser;
        if (userData == null) {
            return;
        }
        floatingPersonalChatView = this.dbp.dbn;
        userData2 = this.dbp.mUser;
        String userName = userData2.getUserName();
        bVar = this.dbp.cYo;
        floatingPersonalChatView.a(userName, bVar);
        j = this.dbp.cYn;
        if (j != 0) {
            handler = this.dbp.mHandler;
            runnable = this.dbp.cYs;
            j2 = this.dbp.cYn;
            handler.postDelayed(runnable, j2);
        }
    }
}
