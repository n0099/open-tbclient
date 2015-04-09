package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class o implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity brX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.brX = floatingPersonalChatActivity;
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
        userData = this.brX.mUser;
        if (userData == null) {
            return;
        }
        floatingPersonalChatView = this.brX.brV;
        userData2 = this.brX.mUser;
        String userName = userData2.getUserName();
        bVar = this.brX.bpf;
        floatingPersonalChatView.a(userName, bVar);
        j = this.brX.bpe;
        if (j != 0) {
            handler = this.brX.mHandler;
            runnable = this.brX.bpj;
            j2 = this.brX.bpe;
            handler.postDelayed(runnable, j2);
        }
    }
}
