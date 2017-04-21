package com.baidu.tieba.imMessageCenter.im.chat;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ PersonalChatActivity djA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalChatActivity personalChatActivity) {
        this.djA = personalChatActivity;
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
        absMsglistView = this.djA.cQK;
        userData = this.djA.mUser;
        String userName = userData.getUserName();
        bVar = this.djA.djr;
        absMsglistView.refreshPersonalHeadFooter(userName, bVar);
        j = this.djA.djq;
        if (j != 0) {
            handler = this.djA.mHandler;
            runnable = this.djA.djv;
            j2 = this.djA.djq;
            handler.postDelayed(runnable, j2);
        }
    }
}
