package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity dpU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.dpU = floatingPersonalChatActivity;
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
        userData = this.dpU.mUser;
        if (userData == null) {
            return;
        }
        floatingPersonalChatView = this.dpU.dpS;
        userData2 = this.dpU.mUser;
        String userName = userData2.getUserName();
        bVar = this.dpU.dmT;
        floatingPersonalChatView.a(userName, bVar);
        j = this.dpU.dmS;
        if (j != 0) {
            handler = this.dpU.mHandler;
            runnable = this.dpU.dmX;
            j2 = this.dpU.dmS;
            handler.postDelayed(runnable, j2);
        }
    }
}
