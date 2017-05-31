package com.baidu.tieba.imMessageCenter.im.chat;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes2.dex */
class d implements Runnable {
    final /* synthetic */ PersonalChatActivity diX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalChatActivity personalChatActivity) {
        this.diX = personalChatActivity;
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
        absMsglistView = this.diX.cQk;
        userData = this.diX.mUser;
        String userName = userData.getUserName();
        bVar = this.diX.diO;
        absMsglistView.refreshPersonalHeadFooter(userName, bVar);
        j = this.diX.diN;
        if (j != 0) {
            handler = this.diX.mHandler;
            runnable = this.diX.diS;
            j2 = this.diX.diN;
            handler.postDelayed(runnable, j2);
        }
    }
}
