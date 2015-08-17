package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity bIA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.bIA = floatingPersonalChatActivity;
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
        userData = this.bIA.mUser;
        if (userData == null) {
            return;
        }
        floatingPersonalChatView = this.bIA.bIy;
        userData2 = this.bIA.mUser;
        String userName = userData2.getUserName();
        bVar = this.bIA.bFA;
        floatingPersonalChatView.a(userName, bVar);
        j = this.bIA.bFz;
        if (j != 0) {
            handler = this.bIA.mHandler;
            runnable = this.bIA.bFE;
            j2 = this.bIA.bFz;
            handler.postDelayed(runnable, j2);
        }
    }
}
