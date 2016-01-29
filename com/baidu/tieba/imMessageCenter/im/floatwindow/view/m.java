package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity ckw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.ckw = floatingPersonalChatActivity;
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
        userData = this.ckw.mUser;
        if (userData == null) {
            return;
        }
        floatingPersonalChatView = this.ckw.cku;
        userData2 = this.ckw.mUser;
        String userName = userData2.getUserName();
        bVar = this.ckw.chw;
        floatingPersonalChatView.a(userName, bVar);
        j = this.ckw.chv;
        if (j != 0) {
            handler = this.ckw.mHandler;
            runnable = this.ckw.chA;
            j2 = this.ckw.chv;
            handler.postDelayed(runnable, j2);
        }
    }
}
