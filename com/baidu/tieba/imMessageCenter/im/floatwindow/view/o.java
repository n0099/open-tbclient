package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class o implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity buJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.buJ = floatingPersonalChatActivity;
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
        userData = this.buJ.mUser;
        if (userData == null) {
            return;
        }
        floatingPersonalChatView = this.buJ.buH;
        userData2 = this.buJ.mUser;
        String userName = userData2.getUserName();
        bVar = this.buJ.brL;
        floatingPersonalChatView.a(userName, bVar);
        j = this.buJ.brK;
        if (j != 0) {
            handler = this.buJ.mHandler;
            runnable = this.buJ.brP;
            j2 = this.buJ.brK;
            handler.postDelayed(runnable, j2);
        }
    }
}
