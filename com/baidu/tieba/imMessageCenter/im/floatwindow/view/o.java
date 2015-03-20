package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class o implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity brH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.brH = floatingPersonalChatActivity;
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
        userData = this.brH.mUser;
        if (userData == null) {
            return;
        }
        floatingPersonalChatView = this.brH.brF;
        userData2 = this.brH.mUser;
        String userName = userData2.getUserName();
        bVar = this.brH.boP;
        floatingPersonalChatView.a(userName, bVar);
        j = this.brH.boO;
        if (j != 0) {
            handler = this.brH.mHandler;
            runnable = this.brH.boT;
            j2 = this.brH.boO;
            handler.postDelayed(runnable, j2);
        }
    }
}
