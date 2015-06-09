package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class o implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity buK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.buK = floatingPersonalChatActivity;
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
        userData = this.buK.mUser;
        if (userData == null) {
            return;
        }
        floatingPersonalChatView = this.buK.buI;
        userData2 = this.buK.mUser;
        String userName = userData2.getUserName();
        bVar = this.buK.brM;
        floatingPersonalChatView.a(userName, bVar);
        j = this.buK.brL;
        if (j != 0) {
            handler = this.buK.mHandler;
            runnable = this.buK.brQ;
            j2 = this.buK.brL;
            handler.postDelayed(runnable, j2);
        }
    }
}
