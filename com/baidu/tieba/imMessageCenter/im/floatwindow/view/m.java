package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity cvZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.cvZ = floatingPersonalChatActivity;
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
        userData = this.cvZ.mUser;
        if (userData == null) {
            return;
        }
        floatingPersonalChatView = this.cvZ.cvX;
        userData2 = this.cvZ.mUser;
        String userName = userData2.getUserName();
        bVar = this.cvZ.csY;
        floatingPersonalChatView.a(userName, bVar);
        j = this.cvZ.csX;
        if (j != 0) {
            handler = this.cvZ.mHandler;
            runnable = this.cvZ.ctc;
            j2 = this.cvZ.csX;
            handler.postDelayed(runnable, j2);
        }
    }
}
