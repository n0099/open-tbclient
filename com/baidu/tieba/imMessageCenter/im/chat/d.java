package com.baidu.tieba.imMessageCenter.im.chat;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ PersonalChatActivity cth;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalChatActivity personalChatActivity) {
        this.cth = personalChatActivity;
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
        absMsglistView = this.cth.caG;
        userData = this.cth.mUser;
        String userName = userData.getUserName();
        bVar = this.cth.csY;
        absMsglistView.refreshPersonalHeadFooter(userName, bVar);
        j = this.cth.csX;
        if (j != 0) {
            handler = this.cth.mHandler;
            runnable = this.cth.ctc;
            j2 = this.cth.csX;
            handler.postDelayed(runnable, j2);
        }
    }
}
