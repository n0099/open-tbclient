package com.baidu.tieba.imMessageCenter.im.chat;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ PersonalChatActivity diK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalChatActivity personalChatActivity) {
        this.diK = personalChatActivity;
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
        absMsglistView = this.diK.cPW;
        userData = this.diK.mUser;
        String userName = userData.getUserName();
        bVar = this.diK.diB;
        absMsglistView.refreshPersonalHeadFooter(userName, bVar);
        j = this.diK.diA;
        if (j != 0) {
            handler = this.diK.mHandler;
            runnable = this.diK.diF;
            j2 = this.diK.diA;
            handler.postDelayed(runnable, j2);
        }
    }
}
