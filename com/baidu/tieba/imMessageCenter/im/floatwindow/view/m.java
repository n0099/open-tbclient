package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity drr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.drr = floatingPersonalChatActivity;
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
        userData = this.drr.mUser;
        if (userData == null) {
            return;
        }
        floatingPersonalChatView = this.drr.drp;
        userData2 = this.drr.mUser;
        String userName = userData2.getUserName();
        bVar = this.drr.dor;
        floatingPersonalChatView.a(userName, bVar);
        j = this.drr.doq;
        if (j != 0) {
            handler = this.drr.mHandler;
            runnable = this.drr.dov;
            j2 = this.drr.doq;
            handler.postDelayed(runnable, j2);
        }
    }
}
