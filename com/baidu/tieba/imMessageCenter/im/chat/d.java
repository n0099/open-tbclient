package com.baidu.tieba.imMessageCenter.im.chat;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes2.dex */
class d implements Runnable {
    final /* synthetic */ PersonalChatActivity ddC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalChatActivity personalChatActivity) {
        this.ddC = personalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        AbsMsglistView absMsglistView;
        UserData userData;
        com.baidu.tbadk.coreExtra.relationship.b bVar;
        long j;
        Handler handler;
        Runnable runnable;
        long j2;
        absMsglistView = this.ddC.cKM;
        userData = this.ddC.mUser;
        String userName = userData.getUserName();
        bVar = this.ddC.dds;
        absMsglistView.refreshPersonalHeadFooter(userName, bVar);
        j = this.ddC.ddr;
        if (j != 0) {
            handler = this.ddC.mHandler;
            runnable = this.ddC.ddx;
            j2 = this.ddC.ddr;
            handler.postDelayed(runnable, j2);
        }
    }
}
