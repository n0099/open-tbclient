package com.baidu.tieba.imMessageCenter.im.chat;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ PersonalChatActivity csk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalChatActivity personalChatActivity) {
        this.csk = personalChatActivity;
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
        absMsglistView = this.csk.cab;
        userData = this.csk.mUser;
        String userName = userData.getUserName();
        bVar = this.csk.csb;
        absMsglistView.refreshPersonalHeadFooter(userName, bVar);
        j = this.csk.csa;
        if (j != 0) {
            handler = this.csk.mHandler;
            runnable = this.csk.csf;
            j2 = this.csk.csa;
            handler.postDelayed(runnable, j2);
        }
    }
}
